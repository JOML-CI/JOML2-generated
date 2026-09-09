package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link Float3x3} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Float3x3Impl implements Float3x3 {

    public float m00;
    public float m10;
    public float m20;
    public float m01;
    public float m11;
    public float m21;
    public float m02;
    public float m12;
    public float m22;
    public int properties;
    static final Float3x3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x3BbOpsUnsafe()
                    : new Float3x3BbOpsApi();
    static final Float3x3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x3RawOpsUnsafe()
                    : new Float3x3RawOpsApi();

    public Float3x3Impl() {
        m00 = 1;
        m11 = 1;
        m22 = 1;
        properties = Joml.BIT_IDENTITY;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits.
     * <p>
     * The comparison is exact: an element counts as {@code 0} or {@code 1} only when it is exactly
     * that value (as by {@code ==}), with no tolerance. A {@code double} element {@code 1 + 1e-8}
     * is therefore not an identity element, while the {@code float} literal {@code 1 + 1e-8f}
     * already rounds to {@code 1.0f} and is.
     * <p>
     * Only identity, translation and affine are inferred (the identity and a pure translation carry
     * the orthogonal bit they imply); a general rotation block is never recognised as orthogonal. A
     * rotation loaded from a buffer or set from scalars therefore takes the affine dispatch arms
     * until it is rebuilt through a {@code make*} factory, which sets the bits from what it
     * constructs.
     * <p>
     * The bits read this 3x3 matrix homogeneously, as a 2D transform whose last row is
     * {@code (0, 0, 1)}: a 3D rotation held in a 3x3 matrix gets no bits at all (its last row is
     * not {@code (0, 0, 1)}), and only a rotation about the homogeneous axis can carry the
     * orthogonal bit (from its factory).
     * <p>
     * This is a pure query: it does not update this matrix's cached property bits.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.m20 != 0 || this.m21 != 0 || this.m22 != 1) return 0;
        if (this.m00 != 1 || this.m01 != 0 || this.m10 != 0 || this.m11 != 1) return 1;
        if (this.m02 != 0 || this.m12 != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    @Override public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    @Override public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal, i.e. its upper-left block is orthonormal with positive determinant (a proper rotation; a reflection is affine, not orthogonal)} O(1) read of the cached property bits; conservative. */
    @Override public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is known to be affine} O(1) read of the cached property bits; conservative. */
    @Override public boolean isAffine() { return (this.properties & Joml.BIT_AFFINE) == Joml.BIT_AFFINE; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_identity(int col, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (col) {
            case 0: _idxSw0 = 1.0f; _idxSw1 = 0.0f; _idxSw2 = 0.0f; break;
            case 1: _idxSw0 = 0.0f; _idxSw1 = 1.0f; _idxSw2 = 0.0f; break;
            case 2: _idxSw0 = 0.0f; _idxSw1 = 0.0f; _idxSw2 = 1.0f; break;
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
    private Float3 getColumn_translation(int col, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw3;
        float _idxSw4;
        float _idxSw5;
        switch (col) {
            case 0: _idxSw3 = 1.0f; _idxSw4 = 0.0f; _idxSw5 = 0.0f; break;
            case 1: _idxSw3 = 0.0f; _idxSw4 = 1.0f; _idxSw5 = 0.0f; break;
            case 2: _idxSw3 = this.m02; _idxSw4 = this.m12; _idxSw5 = 1.0f; break;
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
    private Float3 getColumn_general(int col, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw6;
        float _idxSw7;
        float _idxSw8;
        switch (col) {
            case 0: _idxSw6 = this.m00; _idxSw7 = this.m10; _idxSw8 = this.m20; break;
            case 1: _idxSw6 = this.m01; _idxSw7 = this.m11; _idxSw8 = this.m21; break;
            case 2: _idxSw6 = this.m02; _idxSw7 = this.m12; _idxSw8 = this.m22; break;
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
    public Float3 getColumn(int col, @Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getColumn_translation(col, dest);
        return getColumn_general(col, dest);
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double3 getColumn(int col, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _idxSw9;
        float _idxSw10;
        float _idxSw11;
        switch (col) {
            case 0: _idxSw9 = this.m00; _idxSw10 = this.m10; _idxSw11 = this.m20; break;
            case 1: _idxSw9 = this.m01; _idxSw10 = this.m11; _idxSw11 = this.m21; break;
            case 2: _idxSw9 = this.m02; _idxSw10 = this.m12; _idxSw11 = this.m22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw9;
        d.y = _idxSw10;
        d.z = _idxSw11;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_identity(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 0.0f;
        d.y = 0.0f;
        d.z = 0.0f;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = Math.fma(this.m12, this.m12, 1.0f);
        d.x = _t0 < Math.fma(this.m12, this.m12, Math.fma(this.m02, this.m02, 1.0f)) * 1.0E-7f ? 0.0f : (float) Math.atan2(-this.m12, 1.0f);
        d.y = (float) Math.atan2(this.m02, (float) Math.sqrt(_t0));
        d.z = 0.0f;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m12, this.m12, this.m22 * this.m22);
        float _t3 = Math.fma(this.m02, this.m02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = (float) Math.atan2(this.m21, this.m11);
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m12, this.m22);
            d.z = (float) Math.atan2(-this.m01, this.m00);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(this.m02, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXYZ(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXYZ_translation(dest);
        return getEulerAnglesXYZ_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m12, this.m12, this.m22 * this.m22);
        float _t3 = Math.fma(this.m02, this.m02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = (float) Math.atan2(this.m21, this.m11);
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m12, this.m22);
            d.z = (float) Math.atan2(-this.m01, this.m00);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(this.m02, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        if (1.0f < 1.0E-7f) {
            d.x = (float) Math.atan2(-this.m12, 1.0f);
            d.y = 0.0f;
        } else {
            d.x = 0.0f;
            d.y = (float) Math.atan2(this.m02, 1.0f);
        }
        d.z = 0.0f;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m11, this.m11, this.m21 * this.m21);
        float _t3 = Math.fma(this.m01, this.m01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = (float) Math.atan2(-this.m12, this.m22);
            float _buf1 = 0.0f;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            float _buf0 = (float) Math.atan2(this.m21, this.m11);
            float _buf1 = (float) Math.atan2(this.m02, this.m00);
            d.x = _buf0;
            d.y = _buf1;
        }
        d.z = (float) Math.atan2(-this.m01, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXZY(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXZY_translation(dest);
        return getEulerAnglesXZY_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m11, this.m11, this.m21 * this.m21);
        float _t3 = Math.fma(this.m01, this.m01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = (float) Math.atan2(-this.m12, this.m22);
            float _buf1 = 0.0f;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            float _buf0 = (float) Math.atan2(this.m21, this.m11);
            float _buf1 = (float) Math.atan2(this.m02, this.m00);
            d.x = _buf0;
            d.y = _buf1;
        }
        d.z = (float) Math.atan2(-this.m01, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = Math.fma(this.m02, this.m02, 1.0f);
        d.x = (float) Math.atan2(-this.m12, (float) Math.sqrt(_t0));
        d.y = _t0 < Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f)) * 1.0E-7f ? 0.0f : (float) Math.atan2(this.m02, 1.0f);
        d.z = 0.0f;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m02, this.m02, this.m22 * this.m22);
        float _t3 = Math.fma(this.m12, this.m12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            d.y = (float) Math.atan2(-this.m20, this.m00);
            d.z = 0.0f;
        } else {
            d.y = (float) Math.atan2(this.m02, this.m22);
            d.z = (float) Math.atan2(this.m10, this.m11);
        }
        d.x = (float) Math.atan2(-this.m12, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYXZ(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYXZ_translation(dest);
        return getEulerAnglesYXZ_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m02, this.m02, this.m22 * this.m22);
        float _t3 = Math.fma(this.m12, this.m12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            d.y = (float) Math.atan2(-this.m20, this.m00);
            d.z = 0.0f;
        } else {
            d.y = (float) Math.atan2(this.m02, this.m22);
            d.z = (float) Math.atan2(this.m10, this.m11);
        }
        d.x = (float) Math.atan2(-this.m12, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = Math.fma(this.m12, this.m12, 1.0f);
        float _t1 = _t0 * 1.0E-7f;
        if (_t0 < _t1) {
            d.x = 0.0f;
            d.y = (float) Math.atan2(this.m02, 1.0f);
        } else {
            d.x = (float) Math.atan2(-this.m12, 1.0f);
            d.y = 0.0f;
        }
        d.z = (float) Math.atan2(0.0f, (float) Math.sqrt(_t0));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m11, this.m11, this.m12 * this.m12);
        float _t3 = Math.fma(this.m10, this.m10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.y = (float) Math.atan2(this.m02, this.m22);
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m12, this.m11);
            d.y = (float) Math.atan2(-this.m20, this.m00);
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(this.m10, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYZX(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYZX_translation(dest);
        return getEulerAnglesYZX_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m11, this.m11, this.m12 * this.m12);
        float _t3 = Math.fma(this.m10, this.m10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.y = (float) Math.atan2(this.m02, this.m22);
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m12, this.m11);
            d.y = (float) Math.atan2(-this.m20, this.m00);
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(this.m10, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Float3 getEulerAnglesZXY_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Float3 getEulerAnglesZXY_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        float _t3 = Math.fma(this.m21, this.m21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(this.m10, this.m00);
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m20, this.m22);
            d.z = (float) Math.atan2(-this.m01, this.m11);
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(this.m21, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZXY(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZXY_identity(dest);
        return getEulerAnglesZXY_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        float _t3 = Math.fma(this.m21, this.m21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(this.m10, this.m00);
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(-this.m20, this.m22);
            d.z = (float) Math.atan2(-this.m01, this.m11);
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(this.m21, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_orthogonal(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 0.0f;
        float _buf1 = 0.0f;
        d.z = 1.0f < 1.0E-7f ? (float) Math.atan2(-this.m01, this.m11) : (float) Math.atan2(this.m10, this.m00);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = Math.fma(this.m21, this.m21, this.m22 * this.m22);
        float _t3 = Math.fma(this.m20, this.m20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(-this.m01, this.m11);
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(this.m21, this.m22);
            d.z = (float) Math.atan2(this.m10, this.m00);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(-this.m20, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZYX(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZYX_identity(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getEulerAnglesZYX_orthogonal(dest);
        return getEulerAnglesZYX_general(dest);
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = Math.fma(this.m21, this.m21, this.m22 * this.m22);
        float _t3 = Math.fma(this.m20, this.m20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(-this.m01, this.m11);
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(this.m21, this.m22);
            d.z = (float) Math.atan2(this.m10, this.m00);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(-this.m20, (float) Math.sqrt(_t1));
        return d;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_identity(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = 0.0f;
        d.y = 0.0f;
        d.z = 0.0f;
        d.w = 1.0f;
        return d;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_translation(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t1 = Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f));
        float _t2 = (1.0f / (float) Math.sqrt(_t1));
        float _t5, _t8, _t9;
        if (_t1 > 0.0f) {
            _t5 = _t2;
            _t8 = this.m12 * _t2;
            _t9 = this.m02 * _t2;
        } else {
            _t5 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t6 = Math.max(1.0f, _t5);
        float _t10 = _t5 < 0.0f ? -1.0f : 1.0f;
        float _t11 = 1.0f + _t10;
        float _t13 = _t11 + _t5;
        float _t17 = 1.0f + _t13;
        float _t18 = 1.0f + (_t10 - (1.0f + _t5));
        float _t19 = 1.0f + (_t5 - _t11);
        float _t20 = 1.0f + (1.0f - (_t10 + _t5));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t19));
        float _t23 = (1.0f / (float) Math.sqrt(_t18));
        float _t24 = (1.0f / (float) Math.sqrt(_t20));
        if (_t13 > 0.0f) {
            d.x = -(0.5f * _t21 * _t8);
            d.y = 0.5f * _t21 * _t9;
            d.z = 0.0f;
            d.w = 0.5f * (float) Math.sqrt(_t17);
        } else {
            if (_t10 > _t6) {
                d.x = 0.5f * (float) Math.sqrt(_t18);
                d.y = 0.0f;
                d.z = 0.5f * _t23 * _t9;
                d.w = -(0.5f * _t23 * _t8);
            } else {
                if (1.0f > _t5) {
                    d.x = 0.0f;
                    d.y = 0.5f * (float) Math.sqrt(_t20);
                    d.z = 0.5f * _t24 * _t8;
                    d.w = 0.5f * _t24 * _t9;
                } else {
                    d.x = 0.5f * _t22 * _t9;
                    d.y = 0.5f * _t22 * _t8;
                    d.z = 0.5f * (float) Math.sqrt(_t19);
                    d.w = 0.0f;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_general(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t6 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t7 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t8 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21, _t23, _t27;
        if (_t6 > 0.0f) {
            _t21 = this.m01 * _t9;
            _t23 = this.m11 * _t9;
            _t27 = this.m21 * _t9;
        } else {
            _t21 = 0.0f;
            _t23 = 0.0f;
            _t27 = 0.0f;
        }
        float _t22, _t24, _t26;
        if (_t7 > 0.0f) {
            _t22 = this.m12 * _t10;
            _t24 = this.m02 * _t10;
            _t26 = this.m22 * _t10;
        } else {
            _t22 = 0.0f;
            _t24 = 0.0f;
            _t26 = 0.0f;
        }
        float _t25, _t28, _t29;
        if (_t8 > 0.0f) {
            _t25 = this.m20 * _t11;
            _t28 = this.m00 * _t11;
            _t29 = this.m10 * _t11;
        } else {
            _t25 = 0.0f;
            _t28 = 0.0f;
            _t29 = 0.0f;
        }
        float _t36 = _t27 - _t22;
        float _t37 = Math.max(_t23, _t26);
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49, _t50, _t51;
        if (_t48 < 0.0f) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        if (_t58 > 0.0f) {
            d.x = 0.5f * _t36 * _t66;
            d.y = 0.5f * _t56 * _t66;
            d.z = 0.5f * _t57 * _t66;
            d.w = 0.5f * (float) Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                d.x = 0.5f * (float) Math.sqrt(_t63);
                d.y = 0.5f * _t53 * _t69;
                d.z = 0.5f * _t55 * _t69;
                d.w = 0.5f * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    d.x = 0.5f * _t53 * _t67;
                    d.y = 0.5f * (float) Math.sqrt(_t64);
                    d.z = 0.5f * _t39 * _t67;
                    d.w = 0.5f * _t56 * _t67;
                } else {
                    d.x = 0.5f * _t55 * _t68;
                    d.y = 0.5f * _t39 * _t68;
                    d.z = 0.5f * (float) Math.sqrt(_t65);
                    d.w = 0.5f * _t57 * _t68;
                }
            }
        }
        return d;
    }


    /**
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat getNormalizedRotation(@Mutated FloatQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getNormalizedRotation_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getNormalizedRotation_translation(dest);
        return getNormalizedRotation_general(dest);
    }


    /**
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getNormalizedRotation(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t6 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t7 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t8 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21, _t23, _t27;
        if (_t6 > 0.0f) {
            _t21 = this.m01 * _t9;
            _t23 = this.m11 * _t9;
            _t27 = this.m21 * _t9;
        } else {
            _t21 = 0.0f;
            _t23 = 0.0f;
            _t27 = 0.0f;
        }
        float _t22, _t24, _t26;
        if (_t7 > 0.0f) {
            _t22 = this.m12 * _t10;
            _t24 = this.m02 * _t10;
            _t26 = this.m22 * _t10;
        } else {
            _t22 = 0.0f;
            _t24 = 0.0f;
            _t26 = 0.0f;
        }
        float _t25, _t28, _t29;
        if (_t8 > 0.0f) {
            _t25 = this.m20 * _t11;
            _t28 = this.m00 * _t11;
            _t29 = this.m10 * _t11;
        } else {
            _t25 = 0.0f;
            _t28 = 0.0f;
            _t29 = 0.0f;
        }
        float _t36 = _t27 - _t22;
        float _t37 = Math.max(_t23, _t26);
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49, _t50, _t51;
        if (_t48 < 0.0f) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        if (_t58 > 0.0f) {
            d.x = 0.5f * _t36 * _t66;
            d.y = 0.5f * _t56 * _t66;
            d.z = 0.5f * _t57 * _t66;
            d.w = 0.5f * (float) Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                d.x = 0.5f * (float) Math.sqrt(_t63);
                d.y = 0.5f * _t53 * _t69;
                d.z = 0.5f * _t55 * _t69;
                d.w = 0.5f * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    d.x = 0.5f * _t53 * _t67;
                    d.y = 0.5f * (float) Math.sqrt(_t64);
                    d.z = 0.5f * _t39 * _t67;
                    d.w = 0.5f * _t56 * _t67;
                } else {
                    d.x = 0.5f * _t55 * _t68;
                    d.y = 0.5f * _t39 * _t68;
                    d.z = 0.5f * (float) Math.sqrt(_t65);
                    d.w = 0.5f * _t57 * _t68;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_identity(int row, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (row) {
            case 0: _idxSw0 = 1.0f; _idxSw1 = 0.0f; _idxSw2 = 0.0f; break;
            case 1: _idxSw0 = 0.0f; _idxSw1 = 1.0f; _idxSw2 = 0.0f; break;
            case 2: _idxSw0 = 0.0f; _idxSw1 = 0.0f; _idxSw2 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        return d;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_translation(int row, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw3;
        float _idxSw4;
        float _idxSw5;
        switch (row) {
            case 0: _idxSw3 = 1.0f; _idxSw4 = 0.0f; _idxSw5 = this.m02; break;
            case 1: _idxSw3 = 0.0f; _idxSw4 = 1.0f; _idxSw5 = this.m12; break;
            case 2: _idxSw3 = 0.0f; _idxSw4 = 0.0f; _idxSw5 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw3;
        d.y = _idxSw4;
        d.z = _idxSw5;
        return d;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_general(int row, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _idxSw6;
        float _idxSw7;
        float _idxSw8;
        switch (row) {
            case 0: _idxSw6 = this.m00; _idxSw7 = this.m01; _idxSw8 = this.m02; break;
            case 1: _idxSw6 = this.m10; _idxSw7 = this.m11; _idxSw8 = this.m12; break;
            case 2: _idxSw6 = this.m20; _idxSw7 = this.m21; _idxSw8 = this.m22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw6;
        d.y = _idxSw7;
        d.z = _idxSw8;
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
    public Float3 getRow(int row, @Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getRow_translation(row, dest);
        return getRow_general(row, dest);
    }


    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Double3 getRow(int row, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _idxSw9;
        float _idxSw10;
        float _idxSw11;
        switch (row) {
            case 0: _idxSw9 = this.m00; _idxSw10 = this.m01; _idxSw11 = this.m02; break;
            case 1: _idxSw9 = this.m10; _idxSw10 = this.m11; _idxSw11 = this.m12; break;
            case 2: _idxSw9 = this.m20; _idxSw10 = this.m21; _idxSw11 = this.m22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw9;
        d.y = _idxSw10;
        d.z = _idxSw11;
        return d;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_identity(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 1.0f;
        d.y = 1.0f;
        d.z = 1.0f;
        return d;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 1.0f;
        d.y = 1.0f;
        d.z = (float) Math.sqrt(Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f)));
        return d;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10)));
        d.y = (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11)));
        d.z = (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12)));
        return d;
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     * <p>
     * For a 2D homogeneous 3x3 matrix the third factor is simply the length of the third column -
     * {@code sqrt(m02² + m12² + 1)} for a 2D affine transform, not a scale of anything.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getScale(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getScale_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getScale_translation(dest);
        return getScale_general(dest);
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     * <p>
     * For a 2D homogeneous 3x3 matrix the third factor is simply the length of the third column -
     * {@code sqrt(m02² + m12² + 1)} for a 2D affine transform, not a scale of anything.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getScale(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10)));
        d.y = (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11)));
        d.z = (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12)));
        return d;
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float2 getTranslation_identity(@Mutated Float2 dest) {
        Float2Impl d = (Float2Impl) dest;
        d.x = 0.0f;
        d.y = 0.0f;
        return d;
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float2 getTranslation_general(@Mutated Float2 dest) {
        Float2Impl d = (Float2Impl) dest;
        d.x = this.m02;
        d.y = this.m12;
        return d;
    }


    /**
     * Get the translation of this matrix, read from its last column as {@code (m02, m12)} (the 2D
     * homogeneous convention) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2 getTranslation(@Mutated Float2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getTranslation_identity(dest);
        return getTranslation_general(dest);
    }


    /**
     * Get the translation of this matrix, read from its last column as {@code (m02, m12)} (the 2D
     * homogeneous convention) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getTranslation(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.m02;
        d.y = this.m12;
        return d;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_identity(@Mutated FloatQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_translation(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = -(0.25f * this.m12);
        d.y = 0.25f * this.m02;
        d.z = 0.0f;
        d.w = 1.0f;
        return d;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_orthogonal(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = Math.max(this.m11, 1.0f);
        float _t3 = this.m00 + this.m11;
        float _t4 = this.m01 + this.m10;
        float _t5 = this.m10 - this.m01;
        float _t6 = 1.0f + _t3;
        float _t10 = 1.0f + _t6;
        float _t11 = 1.0f + (this.m00 - (1.0f + this.m11));
        float _t12 = 1.0f + (this.m11 - (1.0f + this.m00));
        float _t13 = 1.0f + (1.0f - _t3);
        float _t14 = (1.0f / (float) Math.sqrt(_t10));
        float _t15 = (1.0f / (float) Math.sqrt(_t12));
        float _t16 = (1.0f / (float) Math.sqrt(_t13));
        float _t17 = (1.0f / (float) Math.sqrt(_t11));
        if (_t6 > 0.0f) {
            float _buf0 = -(0.5f * this.m12 * _t14);
            d.y = 0.5f * this.m02 * _t14;
            float _buf1 = 0.5f * _t5 * _t14;
            d.w = 0.5f * (float) Math.sqrt(_t10);
            d.x = _buf0;
            d.z = _buf1;
        } else {
            if (this.m00 > _t0) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t11);
                d.y = 0.5f * _t4 * _t17;
                float _buf1 = 0.5f * this.m02 * _t17;
                d.w = -(0.5f * this.m12 * _t17);
                d.x = _buf0;
                d.z = _buf1;
            } else {
                if (this.m11 > 1.0f) {
                    float _buf0 = 0.5f * _t4 * _t15;
                    d.y = 0.5f * (float) Math.sqrt(_t12);
                    float _buf1 = 0.5f * this.m12 * _t15;
                    d.w = 0.5f * this.m02 * _t15;
                    d.x = _buf0;
                    d.z = _buf1;
                } else {
                    float _buf0 = 0.5f * this.m02 * _t16;
                    d.y = 0.5f * this.m12 * _t16;
                    float _buf1 = 0.5f * (float) Math.sqrt(_t13);
                    d.w = 0.5f * _t5 * _t16;
                    d.x = _buf0;
                    d.z = _buf1;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_general(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = this.m00 + this.m11;
        float _t1 = this.m21 - this.m12;
        float _t2 = Math.max(this.m11, this.m22);
        float _t4 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t10 = this.m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (this.m00 - (this.m11 + this.m22));
        float _t16 = 1.0f + (this.m11 - (this.m00 + this.m22));
        float _t17 = 1.0f + (this.m22 - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            float _buf0 = 0.5f * _t1 * _t18;
            d.y = 0.5f * _t7 * _t18;
            d.z = 0.5f * _t9 * _t18;
            d.w = 0.5f * (float) Math.sqrt(_t14);
            d.x = _buf0;
        } else {
            if (this.m00 > _t2) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t15);
                d.y = 0.5f * _t4 * _t21;
                d.z = 0.5f * _t6 * _t21;
                d.w = 0.5f * _t1 * _t21;
                d.x = _buf0;
            } else {
                if (this.m11 > this.m22) {
                    float _buf0 = 0.5f * _t4 * _t19;
                    d.y = 0.5f * (float) Math.sqrt(_t16);
                    d.z = 0.5f * _t8 * _t19;
                    d.w = 0.5f * _t7 * _t19;
                    d.x = _buf0;
                } else {
                    float _buf0 = 0.5f * _t6 * _t20;
                    d.y = 0.5f * _t8 * _t20;
                    d.z = 0.5f * (float) Math.sqrt(_t17);
                    d.w = 0.5f * _t9 * _t20;
                    d.x = _buf0;
                }
            }
        }
        return d;
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat getUnnormalizedRotation(@Mutated FloatQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getUnnormalizedRotation_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getUnnormalizedRotation_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getUnnormalizedRotation_orthogonal(dest);
        return getUnnormalizedRotation_general(dest);
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getUnnormalizedRotation(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = this.m00 + this.m11;
        float _t1 = this.m21 - this.m12;
        float _t2 = Math.max(this.m11, this.m22);
        float _t4 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t10 = this.m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (this.m00 - (this.m11 + this.m22));
        float _t16 = 1.0f + (this.m11 - (this.m00 + this.m22));
        float _t17 = 1.0f + (this.m22 - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            float _buf0 = 0.5f * _t1 * _t18;
            d.y = 0.5f * _t7 * _t18;
            d.z = 0.5f * _t9 * _t18;
            d.w = 0.5f * (float) Math.sqrt(_t14);
            d.x = _buf0;
        } else {
            if (this.m00 > _t2) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t15);
                d.y = 0.5f * _t4 * _t21;
                d.z = 0.5f * _t6 * _t21;
                d.w = 0.5f * _t1 * _t21;
                d.x = _buf0;
            } else {
                if (this.m11 > this.m22) {
                    float _buf0 = 0.5f * _t4 * _t19;
                    d.y = 0.5f * (float) Math.sqrt(_t16);
                    d.z = 0.5f * _t8 * _t19;
                    d.w = 0.5f * _t7 * _t19;
                    d.x = _buf0;
                } else {
                    float _buf0 = 0.5f * _t6 * _t20;
                    d.y = 0.5f * _t8 * _t20;
                    d.z = 0.5f * (float) Math.sqrt(_t17);
                    d.w = 0.5f * _t9 * _t20;
                    d.x = _buf0;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = -this.m02;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = -this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m20 = -this.m02;
        d.m21 = -this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m20 = Math.fma(-this.m02, this.m11, -(this.m10 * this.m12));
        d.m01 = -this.m10;
        float _buf1 = this.m11;
        d.m21 = Math.fma(this.m02, this.m10, -(this.m11 * this.m12));
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m20 = Math.fma(-this.m02, this.m11, -(this.m10 * this.m12));
        d.m01 = -this.m10;
        float _buf1 = this.m11;
        d.m21 = Math.fma(this.m02, this.m10, -(this.m11 * this.m12));
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m11;
        float _buf1 = -this.m01;
        d.m20 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _buf2 = -this.m10;
        float _buf3 = this.m00;
        d.m21 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _buf1 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _buf2 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _buf3 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _buf5 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        d.m02 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        d.m12 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 cofactor(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return cofactor_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine(dest);
        return cofactor_general(dest);
    }


    /**
     * Compute the cofactor matrix of this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 cofactor() {
        if (Joml.RETURN_NEW) return cofactor(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return cofactor_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine(this);
        return cofactor_general(this);
    }


    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 cofactor(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _buf1 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _buf2 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _buf3 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _buf5 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        d.m02 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        d.m12 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    public float determinant() {
        return Math.fma(this.m02, Math.fma(this.m10, this.m21, -(this.m11 * this.m20)), Math.fma(this.m00, Math.fma(this.m11, this.m22, -(this.m12 * this.m21)), -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public float frobeniusNorm() {
        return (float) Math.sqrt(Math.fma(this.m00, this.m00, this.m01 * this.m01) + Math.fma(this.m02, this.m02, this.m10 * this.m10) + (Math.fma(this.m11, this.m11, this.m12 * this.m12) + Math.fma(this.m20, this.m20, Math.fma(this.m21, this.m21, this.m22 * this.m22))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_identity(@Mutated Float3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_identity_self(@Mutated Float3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        float _buf1 = this.m11;
        d.m21 = 0.0f;
        float _buf2 = Math.fma(-this.m02, this.m11, -(this.m10 * this.m12));
        d.m12 = Math.fma(this.m02, this.m10, -(this.m11 * this.m12));
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = -this.m10;
        d.m01 = this.m10;
        float _buf1 = this.m11;
        float _buf2 = Math.fma(-this.m02, this.m11, -(this.m10 * this.m12));
        d.m12 = Math.fma(this.m02, this.m10, -(this.m11 * this.m12));
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = this.m11 * _t2_inv;
        float _buf1 = -(this.m10 * _t2_inv);
        d.m20 = 0.0f;
        float _buf2 = -(this.m01 * _t2_inv);
        float _buf3 = this.m00 * _t2_inv;
        d.m21 = 0.0f;
        float _buf4 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = this.m11 * _t2_inv;
        float _buf1 = -(this.m10 * _t2_inv);
        float _buf2 = -(this.m01 * _t2_inv);
        float _buf3 = this.m00 * _t2_inv;
        float _buf4 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv;
        float _buf2 = _t7 * _t12_inv;
        float _buf3 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv;
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv;
        d.m21 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv;
        float _buf5 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m02 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Invert this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 invert(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine(dest);
        return invert_general(dest);
    }


    /**
     * Invert this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 invert() {
        if (Joml.RETURN_NEW) return invert(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine_self(this);
        return invert_general(this);
    }


    /**
     * Invert this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invert(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv;
        float _buf2 = _t7 * _t12_inv;
        float _buf3 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv;
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv;
        d.m21 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv;
        float _buf5 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m02 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t18 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        float _t19 = Math.fma(other.m22(), this.m22, Math.fma(other.m02(), this.m20, other.m12() * this.m21));
        float _t20 = Math.fma(other.m21(), this.m22, Math.fma(other.m01(), this.m20, other.m11() * this.m21));
        float _t21 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        float _t22 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        float _t23 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        float _t24 = Math.fma(other.m20(), this.m22, Math.fma(other.m00(), this.m20, other.m10() * this.m21));
        float _t25 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        float _t26 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        d.m00 = _t33 * _t39_inv;
        d.m10 = Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv;
        d.m20 = _t34 * _t39_inv;
        d.m01 = Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv;
        d.m11 = Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv;
        d.m21 = Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv;
        d.m02 = Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv;
        d.m12 = Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv;
        d.m22 = Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t6 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        float _t7 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        float _t12 = Math.fma(other.m02(), _t7, Math.fma(other.m00(), _t6, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22())) * _t12_inv;
        float _buf2 = _t7 * _t12_inv;
        float _buf3 = Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22())) * _t12_inv;
        float _buf4 = Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20())) * _t12_inv;
        d.m21 = Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21())) * _t12_inv;
        float _buf5 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11())) * _t12_inv;
        d.m12 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12())) * _t12_inv;
        d.m22 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10())) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m02 = _buf5;
        d.properties = ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = Math.fma(other.m21(), this.m12, other.m11());
        float _t1 = Math.fma(other.m22(), this.m12, other.m12());
        float _t2 = Math.fma(other.m22(), this.m02, other.m02());
        float _t3 = Math.fma(other.m20(), this.m12, other.m10());
        float _t4 = Math.fma(other.m20(), this.m02, other.m00());
        float _t5 = Math.fma(other.m21(), this.m02, other.m01());
        float _t12 = Math.fma(other.m22(), _t0, -(other.m21() * _t1));
        float _t13 = Math.fma(other.m21(), _t3, -(other.m20() * _t0));
        float _t18 = Math.fma(_t2, _t13, Math.fma(_t4, _t12, -(_t5 * Math.fma(other.m22(), _t3, -(other.m20() * _t1)))));
        float _t18_inv = 1.0f / _t18;
        d.m00 = _t12 * _t18_inv;
        d.m10 = Math.fma(other.m20(), _t1, -(other.m22() * _t3)) * _t18_inv;
        float _buf0 = _t13 * _t18_inv;
        d.m01 = Math.fma(other.m21(), _t2, -(other.m22() * _t5)) * _t18_inv;
        d.m11 = Math.fma(other.m22(), _t4, -(other.m20() * _t2)) * _t18_inv;
        d.m21 = Math.fma(other.m20(), _t5, -(other.m21() * _t4)) * _t18_inv;
        d.m02 = Math.fma(_t5, _t1, -(_t2 * _t0)) * _t18_inv;
        d.m12 = Math.fma(_t2, _t3, -(_t4 * _t1)) * _t18_inv;
        d.m22 = Math.fma(_t4, _t0, -(_t5 * _t3)) * _t18_inv;
        d.m20 = _buf0;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal(Float3x3R other, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t12 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        float _t13 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        float _t14 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        float _t15 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        float _t16 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        float _t17 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        float _t24 = Math.fma(other.m22(), _t12, -(other.m21() * _t13));
        float _t25 = Math.fma(other.m21(), _t15, -(other.m20() * _t12));
        float _t30 = Math.fma(_t14, _t25, Math.fma(_t16, _t24, -(_t17 * Math.fma(other.m22(), _t15, -(other.m20() * _t13)))));
        float _t30_inv = 1.0f / _t30;
        d.m00 = _t24 * _t30_inv;
        d.m10 = Math.fma(other.m20(), _t13, -(other.m22() * _t15)) * _t30_inv;
        float _buf0 = _t25 * _t30_inv;
        d.m01 = Math.fma(other.m21(), _t14, -(other.m22() * _t17)) * _t30_inv;
        d.m11 = Math.fma(other.m22(), _t16, -(other.m20() * _t14)) * _t30_inv;
        d.m21 = Math.fma(other.m20(), _t17, -(other.m21() * _t16)) * _t30_inv;
        d.m02 = Math.fma(_t17, _t13, -(_t12 * _t14)) * _t30_inv;
        d.m12 = Math.fma(_t15, _t14, -(_t16 * _t13)) * _t30_inv;
        d.m22 = Math.fma(_t16, _t12, -(_t15 * _t17)) * _t30_inv;
        d.m20 = _buf0;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -other.m02();
        d.m12 = -other.m12();
        d.m22 = 1.0f;
        d.properties = ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = other.m11() * _t2_inv;
        float _buf1 = -(other.m10() * _t2_inv);
        d.m20 = 0.0f;
        float _buf2 = -(other.m01() * _t2_inv);
        float _buf3 = other.m00() * _t2_inv;
        d.m21 = 0.0f;
        float _buf4 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11())) * _t2_inv;
        d.m12 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12())) * _t2_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -(other.m02() + this.m02);
        d.m12 = -(other.m12() + this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t1 = other.m12() + this.m12;
        float _t2 = other.m02() + this.m02;
        float _t4 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t4_inv = 1.0f / _t4;
        float _buf0 = other.m11() * _t4_inv;
        float _buf1 = -(other.m10() * _t4_inv);
        d.m20 = 0.0f;
        float _buf2 = -(other.m01() * _t4_inv);
        float _buf3 = other.m00() * _t4_inv;
        d.m21 = 0.0f;
        d.m02 = Math.fma(other.m01(), _t1, -(other.m11() * _t2)) * _t4_inv;
        d.m12 = Math.fma(other.m10(), _t2, -(other.m00() * _t1)) * _t4_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        float _buf1 = this.m11;
        d.m21 = 0.0f;
        float _buf2 = Math.fma(-this.m02, this.m11, -(this.m10 * this.m12));
        d.m12 = Math.fma(this.m02, this.m10, -(this.m11 * this.m12));
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = -this.m10;
        d.m00 = this.m11;
        float _buf0 = _t0;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        float _buf1 = this.m11;
        d.m21 = 0.0f;
        float _buf2 = Math.fma(_t0, this.m12, Math.fma(-this.m02, this.m11, -other.m02()));
        d.m12 = Math.fma(this.m02, this.m10, Math.fma(-this.m11, this.m12, -other.m12()));
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_affine(Float3x3R other, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t6 = Math.fma(other.m01(), this.m10, other.m11() * this.m11);
        float _t7 = Math.fma(other.m00(), this.m00, other.m10() * this.m01);
        float _t8 = Math.fma(other.m00(), this.m10, other.m10() * this.m11);
        float _t9 = Math.fma(other.m01(), this.m00, other.m11() * this.m01);
        float _t10 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t11 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        float _t14_inv = 1.0f / _t14;
        d.m00 = _t6 * _t14_inv;
        d.m10 = -(_t8 * _t14_inv);
        d.m20 = 0.0f;
        d.m01 = -(_t9 * _t14_inv);
        d.m11 = _t7 * _t14_inv;
        d.m21 = 0.0f;
        d.m02 = Math.fma(_t10, _t9, -(_t11 * _t6)) * _t14_inv;
        d.m12 = Math.fma(_t11, _t8, -(_t10 * _t7)) * _t14_inv;
        d.m22 = 1.0f;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_affine_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = this.m11 * _t2_inv;
        float _buf1 = -(this.m10 * _t2_inv);
        d.m20 = 0.0f;
        float _buf2 = -(this.m01 * _t2_inv);
        float _buf3 = this.m00 * _t2_inv;
        d.m21 = 0.0f;
        float _buf4 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_affine_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t4 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t4_inv = 1.0f / _t4;
        float _t5 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t6 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _buf0 = this.m11 * _t4_inv;
        float _buf1 = -(this.m10 * _t4_inv);
        d.m20 = 0.0f;
        float _buf2 = -(this.m01 * _t4_inv);
        float _buf3 = this.m00 * _t4_inv;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m01, _t5, -(this.m11 * _t6)) * _t4_inv;
        d.m12 = Math.fma(this.m10, _t6, -(this.m00 * _t5)) * _t4_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv;
        float _buf2 = _t7 * _t12_inv;
        float _buf3 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv;
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv;
        d.m21 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv;
        float _buf5 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv;
        d.m12 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m02 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t5 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t6 = Math.fma(other.m02(), this.m20, Math.fma(other.m12(), this.m21, this.m22));
        float _t7 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t8 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t13 = Math.fma(this.m11, _t6, -(this.m21 * _t7));
        float _t18 = Math.fma(_t8, _t5, Math.fma(this.m00, _t13, -(this.m01 * Math.fma(this.m10, _t6, -(this.m20 * _t7)))));
        float _t18_inv = 1.0f / _t18;
        float _buf0 = _t13 * _t18_inv;
        float _buf1 = Math.fma(this.m20, _t7, -(this.m10 * _t6)) * _t18_inv;
        float _buf2 = _t5 * _t18_inv;
        float _buf3 = Math.fma(this.m21, _t8, -(this.m01 * _t6)) * _t18_inv;
        float _buf4 = Math.fma(this.m00, _t6, -(this.m20 * _t8)) * _t18_inv;
        d.m21 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t18_inv;
        d.m02 = Math.fma(this.m01, _t7, -(this.m11 * _t8)) * _t18_inv;
        d.m12 = Math.fma(this.m10, _t8, -(this.m00 * _t7)) * _t18_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t18_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t9 = Math.fma(other.m01(), this.m10, other.m11() * this.m11);
        float _t10 = Math.fma(other.m01(), this.m20, other.m11() * this.m21);
        float _t11 = Math.fma(other.m00(), this.m10, other.m10() * this.m11);
        float _t12 = Math.fma(other.m00(), this.m20, other.m10() * this.m21);
        float _t13 = Math.fma(other.m00(), this.m00, other.m10() * this.m01);
        float _t14 = Math.fma(other.m01(), this.m00, other.m11() * this.m01);
        float _t15 = Math.fma(other.m02(), this.m20, Math.fma(other.m12(), this.m21, this.m22));
        float _t16 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t17 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t24 = Math.fma(_t11, _t10, -(_t12 * _t9));
        float _t25 = Math.fma(_t15, _t9, -(_t16 * _t10));
        float _t30 = Math.fma(_t17, _t24, Math.fma(_t13, _t25, -(_t14 * Math.fma(_t15, _t11, -(_t16 * _t12)))));
        float _t30_inv = 1.0f / _t30;
        d.m00 = _t25 * _t30_inv;
        d.m10 = Math.fma(_t16, _t12, -(_t15 * _t11)) * _t30_inv;
        d.m20 = _t24 * _t30_inv;
        d.m01 = Math.fma(_t17, _t10, -(_t15 * _t14)) * _t30_inv;
        d.m11 = Math.fma(_t15, _t13, -(_t17 * _t12)) * _t30_inv;
        d.m21 = Math.fma(_t12, _t14, -(_t13 * _t10)) * _t30_inv;
        d.m02 = Math.fma(_t16, _t14, -(_t17 * _t9)) * _t30_inv;
        d.m12 = Math.fma(_t17, _t11, -(_t16 * _t13)) * _t30_inv;
        d.m22 = Math.fma(_t13, _t9, -(_t11 * _t14)) * _t30_inv;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     * <p>
     * The product is formed first and inverted afterwards, so the result is the inverse of the
     * rounded product: its accuracy is bounded by the condition number of {@code this * other}, not
     * by the condition numbers of the two factors. For an ill-conditioned product (a near-singular
     * factor, or factors of very different scale) invert both factors separately and multiply the
     * inverses in reverse order instead.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 invertProduct(Float3x3R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_identity_affine(other, dest);
            return invertProduct_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_translation_affine(other, dest);
            return invertProduct_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, dest, Joml.BIT_ORTHOGONAL & q);
            return invertProduct_orthogonal(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_affine_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_affine_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, dest, Joml.BIT_AFFINE & q);
            return invertProduct_orthogonal(other, dest, Joml.BIT_AFFINE & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_general_affine(other, dest);
        return invertProduct_general(other, dest);
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}.
     * <p>
     * The product is formed first and inverted afterwards, so the result is the inverse of the
     * rounded product: its accuracy is bounded by the condition number of {@code this * other}, not
     * by the condition numbers of the two factors. For an ill-conditioned product (a near-singular
     * factor, or factors of very different scale) invert both factors separately and multiply the
     * inverses in reverse order instead.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 invertProduct(Float3x3R other) {
        if (Joml.RETURN_NEW) return invertProduct(other, Joml.float3x3());
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_identity_affine(other, this);
            return invertProduct_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_translation_affine(other, this);
            return invertProduct_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, this, Joml.BIT_ORTHOGONAL & q);
            return invertProduct_orthogonal(other, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_affine_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_affine_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, this, Joml.BIT_AFFINE & q);
            return invertProduct_orthogonal(other, this, Joml.BIT_AFFINE & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_general_affine(other, this);
        return invertProduct_general(other, this);
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     * <p>
     * The product is formed first and inverted afterwards, so the result is the inverse of the
     * rounded product: its accuracy is bounded by the condition number of {@code this * other}, not
     * by the condition numbers of the two factors. For an ill-conditioned product (a near-singular
     * factor, or factors of very different scale) invert both factors separately and multiply the
     * inverses in reverse order instead.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invertProduct(Float3x3R other, @Mutated Double3x3 dest) {
        return invertProduct(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), other.m20(), other.m21(), other.m22(), dest);
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the
     * result in {@code dest}.
     * <p>
     * The product is formed first and inverted afterwards, so the result is the inverse of the
     * rounded product: its accuracy is bounded by the condition number of the product, not by the
     * condition numbers of the two factors. For an ill-conditioned product (a near-singular factor,
     * or factors of very different scale) invert both factors separately and multiply the inverses
     * in reverse order instead.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 invertProduct(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t18 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _t19 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        float _t20 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        float _t21 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        float _t22 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        float _t23 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _t24 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _t25 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _t26 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        d.m00 = _t33 * _t39_inv;
        d.m10 = Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv;
        d.m20 = _t34 * _t39_inv;
        d.m01 = Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv;
        d.m11 = Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv;
        d.m21 = Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv;
        d.m02 = Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv;
        d.m12 = Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv;
        d.m22 = Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the
     * result in {@code dest}.
     * <p>
     * The product is formed first and inverted afterwards, so the result is the inverse of the
     * rounded product: its accuracy is bounded by the condition number of the product, not by the
     * condition numbers of the two factors. For an ill-conditioned product (a near-singular factor,
     * or factors of very different scale) invert both factors separately and multiply the inverses
     * in reverse order instead.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invertProduct(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t18 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _t19 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        float _t20 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        float _t21 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        float _t22 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        float _t23 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _t24 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _t25 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _t26 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        d.m00 = _t33 * _t39_inv;
        d.m10 = Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv;
        d.m20 = _t34 * _t39_inv;
        d.m01 = Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv;
        d.m11 = Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv;
        d.m21 = Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv;
        d.m02 = Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv;
        d.m12 = Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv;
        d.m22 = Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_identity(@Mutated Float3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_identity_self(@Mutated Float3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_translation(@Mutated Float3x3 dest) {
        return cofactor_translation(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_translation_self(@Mutated Float3x3 dest) {
        return cofactor_translation_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_orthogonal(@Mutated Float3x3 dest) {
        return cofactor_orthogonal(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_orthogonal_self(@Mutated Float3x3 dest) {
        return cofactor_orthogonal_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = this.m11 * _t2_inv;
        float _buf1 = -(this.m01 * _t2_inv);
        d.m20 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv;
        d.m01 = -(this.m10 * _t2_inv);
        d.m11 = this.m00 * _t2_inv;
        d.m21 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = this.m11 * _t2_inv;
        float _buf1 = -(this.m01 * _t2_inv);
        d.m20 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv;
        d.m01 = -(this.m10 * _t2_inv);
        d.m11 = this.m00 * _t2_inv;
        d.m21 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv;
        float _buf2 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv;
        float _buf3 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv;
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv;
        float _buf5 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv;
        d.m02 = _t7 * _t12_inv;
        d.m12 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 normal(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normal_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine(dest);
        return normal_general(dest);
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 normal() {
        if (Joml.RETURN_NEW) return normal(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normal_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine_self(this);
        return normal_general(this);
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 normal(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        float _buf0 = _t6 * _t12_inv;
        float _buf1 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv;
        float _buf2 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv;
        float _buf3 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv;
        float _buf4 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv;
        float _buf5 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv;
        d.m02 = _t7 * _t12_inv;
        d.m12 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv;
        d.m22 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the trace of this matrix.
     *
     * @return the trace of this matrix
     */
    public float trace() {
        return this.m22 + (this.m00 + this.m11);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_identity(@Mutated Float3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_identity_self(@Mutated Float3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = this.m02;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m20 = this.m02;
        d.m21 = this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m01;
        d.m20 = this.m02;
        d.m01 = this.m10;
        d.m11 = this.m11;
        d.m21 = this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m01;
        d.m20 = this.m02;
        d.m01 = this.m10;
        d.m11 = this.m11;
        d.m21 = this.m12;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m01;
        float _buf1 = this.m02;
        d.m01 = this.m10;
        d.m11 = this.m11;
        float _buf2 = this.m12;
        d.m02 = this.m20;
        d.m12 = this.m21;
        d.m22 = this.m22;
        d.m10 = _buf0;
        d.m20 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 transpose(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_orthogonal(dest);
        return transpose_general(dest);
    }


    /**
     * Transpose this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 transpose() {
        if (Joml.RETURN_NEW) return transpose(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_orthogonal_self(this);
        return transpose_general(this);
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 transpose(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m01;
        float _buf1 = this.m02;
        d.m01 = this.m10;
        d.m11 = this.m11;
        float _buf2 = this.m12;
        d.m02 = this.m20;
        d.m12 = this.m21;
        d.m22 = this.m22;
        d.m10 = _buf0;
        d.m20 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00() + this.m00;
        d.m10 = other.m10() + this.m10;
        d.m20 = other.m20() + this.m20;
        d.m01 = other.m01() + this.m01;
        d.m11 = other.m11() + this.m11;
        d.m21 = other.m21() + this.m21;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = other.m22() + this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + other.m00();
        d.m10 = other.m10();
        d.m20 = other.m20();
        d.m01 = other.m01();
        d.m11 = 1.0f + other.m11();
        d.m21 = other.m21();
        d.m02 = other.m02();
        d.m12 = other.m12();
        d.m22 = 1.0f + other.m22();
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + other.m00();
        d.m10 = other.m10();
        d.m20 = other.m20();
        d.m01 = other.m01();
        d.m11 = 1.0f + other.m11();
        d.m21 = other.m21();
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f + other.m22();
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 2.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 2.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f;
        d.m21 = 0.0f;
        d.m02 = other.m02();
        d.m12 = other.m12();
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = 1.0f + other.m11();
        d.m21 = 0.0f;
        d.m02 = other.m02();
        d.m12 = other.m12();
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 2.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 2.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = 1.0f + other.m11();
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_orthogonal_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = 1.0f + this.m11;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_orthogonal_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = 1.0f + this.m11;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 2.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = 1.0f + this.m11;
        d.m21 = this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f + this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f + this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = 1.0f + this.m11;
        d.m21 = this.m21;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f + this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 add(Float3x3R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_identity_affine(other, dest);
            return add_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, dest);
            return add_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
            return add_general(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
            return add_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, dest);
        return add_general(other, dest);
    }


    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 add(Float3x3R other) {
        if (Joml.RETURN_NEW) return add(other, Joml.float3x3());
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_identity_affine(other, this);
            return add_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, this);
            return add_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
            return add_general(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
            return add_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, this);
        return add_general(other, this);
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 add(Float3x3R other, @Mutated Double3x3 dest) {
        return add(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), other.m20(), other.m21(), other.m22(), dest);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) to this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 add(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = m00 + this.m00;
        d.m10 = m10 + this.m10;
        d.m20 = m20 + this.m20;
        d.m01 = m01 + this.m01;
        d.m11 = m11 + this.m11;
        d.m21 = m21 + this.m21;
        d.m02 = m02 + this.m02;
        d.m12 = m12 + this.m12;
        d.m22 = m22 + this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 add(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = m00 + this.m00;
        d.m10 = m10 + this.m10;
        d.m20 = m20 + this.m20;
        d.m01 = m01 + this.m01;
        d.m11 = m11 + this.m11;
        d.m21 = m21 + this.m21;
        d.m02 = m02 + this.m02;
        d.m12 = m12 + this.m12;
        d.m22 = m22 + this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m11 = -1.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m11 = -1.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = -this.m11;
        d.m00 = _t0;
        float _buf0 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = -this.m11;
        d.m00 = _t0;
        float _buf0 = -this.m10;
        d.m01 = this.m10;
        d.m11 = _t0;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 negate(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine(dest);
        return negate_general(dest);
    }


    /**
     * Negate this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 negate() {
        if (Joml.RETURN_NEW) return negate(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine_self(this);
        return negate_general(this);
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 negate(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - other.m00();
        d.m10 = this.m10 - other.m10();
        d.m20 = this.m20 - other.m20();
        d.m01 = this.m01 - other.m01();
        d.m11 = this.m11 - other.m11();
        d.m21 = this.m21 - other.m21();
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = this.m22 - other.m22();
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f - other.m00();
        d.m10 = -other.m10();
        d.m20 = -other.m20();
        d.m01 = -other.m01();
        d.m11 = 1.0f - other.m11();
        d.m21 = -other.m21();
        d.m02 = -other.m02();
        d.m12 = -other.m12();
        d.m22 = 1.0f - other.m22();
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = -other.m02();
        d.m12 = -other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f - other.m00();
        d.m10 = -other.m10();
        d.m20 = 0.0f;
        d.m01 = -other.m01();
        d.m11 = 1.0f - other.m11();
        d.m21 = 0.0f;
        d.m02 = -other.m02();
        d.m12 = -other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f - other.m00();
        d.m10 = -other.m10();
        d.m20 = 0.0f;
        d.m01 = -other.m01();
        d.m11 = 1.0f - other.m11();
        d.m21 = 0.0f;
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - 1.0f;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11 - 1.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - 1.0f;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11 - 1.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - other.m00();
        d.m10 = this.m10 - other.m10();
        d.m20 = 0.0f;
        d.m01 = this.m01 - other.m01();
        d.m11 = this.m11 - other.m11();
        d.m21 = 0.0f;
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general_identity(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - 1.0f;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11 - 1.0f;
        d.m21 = this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22 - 1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - 1.0f;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11 - 1.0f;
        d.m21 = this.m21;
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = this.m22 - 1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 sub(Float3x3R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_identity_affine(other, dest);
            return sub_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 sub(Float3x3R other) {
        if (Joml.RETURN_NEW) return sub(other, Joml.float3x3());
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_identity_affine(other, this);
            return sub_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, this);
            return sub_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, this);
        return sub_general(other, this);
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 sub(Float3x3R other, @Mutated Double3x3 dest) {
        return sub(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), other.m20(), other.m21(), other.m22(), dest);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) from this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 sub(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 - m00;
        d.m10 = this.m10 - m10;
        d.m20 = this.m20 - m20;
        d.m01 = this.m01 - m01;
        d.m11 = this.m11 - m11;
        d.m21 = this.m21 - m21;
        d.m02 = this.m02 - m02;
        d.m12 = this.m12 - m12;
        d.m22 = this.m22 - m22;
        d.properties = 0;
        return d;
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 sub(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00 - m00;
        d.m10 = this.m10 - m10;
        d.m20 = this.m20 - m20;
        d.m01 = this.m01 - m01;
        d.m11 = this.m11 - m11;
        d.m21 = this.m21 - m21;
        d.m02 = this.m02 - m02;
        d.m12 = this.m12 - m12;
        d.m22 = this.m22 - m22;
        d.properties = 0;
        return d;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Float3x3 set(Float3x3R v) {
        this.m00 = v.m00();
        this.m10 = v.m10();
        this.m20 = v.m20();
        this.m01 = v.m01();
        this.m11 = v.m11();
        this.m21 = v.m21();
        this.m02 = v.m02();
        this.m12 = v.m12();
        this.m22 = v.m22();
        this.properties = ((Float3x3Impl) v).properties;
        return this;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated public Float3x3 set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00 = m00;
        this.m10 = m10;
        this.m20 = m20;
        this.m01 = m01;
        this.m11 = m11;
        this.m21 = m21;
        this.m02 = m02;
        this.m12 = m12;
        this.m22 = m22;
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x2 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float3x3 set(Float2x2R m) {
        this.m00 = m.m00();
        this.m10 = m.m10();
        this.m20 = 0.0f;
        this.m01 = m.m01();
        this.m11 = m.m11();
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x3 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float3x3 set(Float2x3R m) {
        this.m00 = m.m00();
        this.m10 = m.m10();
        this.m20 = 0.0f;
        this.m01 = m.m01();
        this.m11 = m.m11();
        this.m21 = 0.0f;
        this.m02 = m.m02();
        this.m12 = m.m12();
        this.m22 = 1.0f;
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 3x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float3x3 set(Float3x4R m) {
        this.m00 = m.m00();
        this.m10 = m.m10();
        this.m20 = m.m20();
        this.m01 = m.m01();
        this.m11 = m.m11();
        this.m21 = m.m21();
        this.m02 = m.m02();
        this.m12 = m.m12();
        this.m22 = m.m22();
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 4x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float3x3 set(Float4x4R m) {
        this.m00 = m.m00();
        this.m10 = m.m10();
        this.m20 = m.m20();
        this.m01 = m.m01();
        this.m11 = m.m11();
        this.m21 = m.m21();
        this.m02 = m.m02();
        this.m12 = m.m12();
        this.m22 = m.m22();
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 withTranslation(Float2R t, @Mutated Float3x3 dest) {
        return withTranslation(t.x(), t.y(), dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 withTranslation(Float2R t, @Mutated Double3x3 dest) {
        return withTranslation(t.x(), t.y(), dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param t the translation offsets
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 withTranslation(Float2R t) {
        return withTranslation(t.x(), t.y());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_orthogonal_affine(float tX, float tY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = tX;
        d.m12 = tY;
        d.m22 = 1.0f;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_orthogonal_affine_self(float tX, float tY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = tX;
        d.m12 = tY;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_identity(float tX, float tY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = tX;
        d.m12 = tY;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_identity_self(float tX, float tY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m02 = tX;
        d.m12 = tY;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_general(float tX, float tY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = tX;
        d.m12 = tY;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 withTranslation(float tX, float tY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return withTranslation_orthogonal_affine(tX, tY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return withTranslation_general(tX, tY, dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 withTranslation(float tX, float tY) {
        if (Joml.RETURN_NEW) return withTranslation(tX, tY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity_self(tX, tY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return withTranslation_orthogonal_affine_self(tX, tY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return withTranslation_general(tX, tY, this);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 withTranslation(float tX, float tY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = tX;
        d.m12 = tY;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Convert this matrix to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toDouble(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = this.properties;
        return d;
    }


    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
     *
     * @param r the rigid transform (whose rotation must be a unit quaternion)
     * @return this
     */
    public @Mutated Float3x3 makeFromRigid(FloatRigidR r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
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
    @Mutated public Float3x3 makeFromRigid(float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        this.m00 = Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f);
        this.m10 = 2.0f * Math.fma(rRX, rRY, _t1);
        this.m20 = 2.0f * Math.fma(rRX, rRZ, -_t2);
        this.m01 = 2.0f * Math.fma(rRX, rRY, -_t1);
        this.m11 = Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f);
        this.m21 = 2.0f * Math.fma(rRX, rRW, rRY * rRZ);
        this.m02 = 2.0f * Math.fma(rRX, rRZ, _t2);
        this.m12 = 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW));
        this.m22 = Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f);
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
     *
     * @param t the transform
     * @return this
     */
    public @Mutated Float3x3 makeFromTransform(FloatTransformR t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
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
    @Mutated public Float3x3 makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        this.m00 = tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f);
        this.m10 = tSX * 2.0f * Math.fma(tRX, tRY, _t1);
        this.m20 = tSX * 2.0f * Math.fma(tRX, tRZ, -_t2);
        this.m01 = tSY * 2.0f * Math.fma(tRX, tRY, -_t1);
        this.m11 = tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f);
        this.m21 = tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ);
        this.m02 = tSZ * 2.0f * Math.fma(tRX, tRZ, _t2);
        this.m12 = tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW));
        this.m22 = tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f);
        this.properties = 0;
        return this;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Float2x2 to2x2_identity(@Mutated Float2x2 dest) {
        Float2x2Impl d = (Float2x2Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Float2x2 to2x2_general(@Mutated Float2x2 dest) {
        Float2x2Impl d = (Float2x2Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.properties = 0;
        return d;
    }


    /**
     * Extract the upper-left 2x2 linear block of this matrix (dropping the translation column and
     * the last row) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 to2x2(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x2_identity(dest);
        return to2x2_general(dest);
    }


    /**
     * Extract the upper-left 2x2 linear block of this matrix (dropping the translation column and
     * the last row) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 to2x2(@Mutated Double2x2 dest) {
        Double2x2Impl d = (Double2x2Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_orthogonal_general(@Mutated Float2x3 dest, int _props) {
        Float2x3Impl d = (Float2x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_identity(@Mutated Float2x3 dest) {
        Float2x3Impl d = (Float2x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_translation(@Mutated Float2x3 dest) {
        Float2x3Impl d = (Float2x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Truncate this matrix to a 2x3 matrix, dropping the last row (assumed {@code 0, 0, 1}) and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x3 to2x3(@Mutated Float2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to2x3_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x3_translation(dest);
        return to2x3_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Truncate this matrix to a 2x3 matrix, dropping the last row (assumed {@code 0, 0, 1}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 to2x3(@Mutated Double2x3 dest) {
        Double2x3Impl d = (Double2x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_identity(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        d.m00 = 1.0f;
        d.m01 = 0.0f;
        d.m02 = 0.0f;
        d.m03 = 0.0f;
        d.m10 = 0.0f;
        d.m11 = 1.0f;
        d.m12 = 0.0f;
        d.m13 = 0.0f;
        d.m20 = 0.0f;
        d.m21 = 0.0f;
        d.m22 = 1.0f;
        d.m23 = 0.0f;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_translation(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        d.m00 = 1.0f;
        d.m01 = 0.0f;
        d.m02 = this.m02;
        d.m03 = 0.0f;
        d.m10 = 0.0f;
        float _buf0 = 1.0f;
        d.m12 = this.m12;
        d.m13 = 0.0f;
        d.m20 = 0.0f;
        d.m21 = 0.0f;
        d.m22 = 1.0f;
        d.m23 = 0.0f;
        d.m11 = _buf0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_orthogonal(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        float _buf0 = 0.0f;
        float _buf1 = this.m10;
        float _buf2 = this.m11;
        d.m12 = this.m12;
        d.m13 = 0.0f;
        d.m20 = 0.0f;
        d.m21 = 0.0f;
        d.m22 = 1.0f;
        d.m23 = 0.0f;
        d.m03 = _buf0;
        d.m10 = _buf1;
        d.m11 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_general(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        float _buf0 = 0.0f;
        float _buf1 = this.m10;
        float _buf2 = this.m11;
        float _buf3 = this.m12;
        float _buf4 = 0.0f;
        float _buf5 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = 0.0f;
        d.m03 = _buf0;
        d.m10 = _buf1;
        d.m11 = _buf2;
        d.m12 = _buf3;
        d.m13 = _buf4;
        d.m20 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Extend this matrix to a 3x4 matrix with a zero translation column and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x4 to3x4(@Mutated Float3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to3x4_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x4_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to3x4_orthogonal(dest);
        return to3x4_general(dest);
    }


    /**
     * Extend this matrix to a 3x4 matrix with a zero translation column and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 to3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        float _buf0 = 0.0f;
        float _buf1 = this.m10;
        float _buf2 = this.m11;
        float _buf3 = this.m12;
        float _buf4 = 0.0f;
        float _buf5 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = 0.0f;
        d.m03 = _buf0;
        d.m10 = _buf1;
        d.m11 = _buf2;
        d.m12 = _buf3;
        d.m13 = _buf4;
        d.m20 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_identity(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m30 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m31 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_translation(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m30 = 0.0f;
        d.m01 = 0.0f;
        float _buf0 = 1.0f;
        d.m21 = 0.0f;
        d.m31 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m11 = _buf0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_orthogonal(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m10;
        d.m20 = 0.0f;
        d.m30 = 0.0f;
        d.m01 = this.m01;
        float _buf1 = this.m11;
        d.m21 = 0.0f;
        d.m31 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_general(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m10;
        float _buf1 = this.m20;
        d.m30 = 0.0f;
        d.m01 = this.m01;
        float _buf2 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m10 = _buf0;
        d.m20 = _buf1;
        d.m11 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Extend this matrix to a 4x4 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x4 to4x4(@Mutated Float4x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to4x4_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to4x4_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to4x4_orthogonal(dest);
        return to4x4_general(dest);
    }


    /**
     * Extend this matrix to a 4x4 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 to4x4(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m10;
        float _buf1 = this.m20;
        d.m30 = 0.0f;
        d.m01 = this.m01;
        float _buf2 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m10 = _buf0;
        d.m20 = _buf1;
        d.m11 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_identity(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = 0.0f;
        d.rY = 0.0f;
        d.rZ = 0.0f;
        d.rW = 1.0f;
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_translation(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = -(0.25f * this.m12);
        d.rY = 0.25f * this.m02;
        d.rZ = 0.0f;
        d.rW = 1.0f;
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_orthogonal(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = Math.max(this.m11, 1.0f);
        float _t2 = 1.0f - this.m00;
        float _t4 = this.m01 + this.m10;
        float _t5 = this.m10 - this.m01;
        float _t8 = 1.0f + (this.m00 + this.m11);
        float _t10 = 1.0f + _t8;
        float _t11 = this.m00 + (1.0f - this.m11 - 1.0f);
        float _t12 = this.m11 + (_t2 - 1.0f);
        float _t13 = 1.0f + (_t2 - this.m11);
        float _t14 = (1.0f / (float) Math.sqrt(_t10));
        float _t15 = (1.0f / (float) Math.sqrt(_t12));
        float _t16 = (1.0f / (float) Math.sqrt(_t13));
        float _t17 = (1.0f / (float) Math.sqrt(_t11));
        if (_t8 > 0.0f) {
            float _buf0 = -(0.5f * this.m12 * _t14);
            d.rY = 0.5f * this.m02 * _t14;
            float _buf1 = 0.5f * _t5 * _t14;
            d.rW = 0.5f * (float) Math.sqrt(_t10);
            d.rX = _buf0;
            d.rZ = _buf1;
        } else {
            if (this.m00 > _t0) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t11);
                d.rY = 0.5f * _t4 * _t17;
                float _buf1 = 0.5f * this.m02 * _t17;
                d.rW = -(0.5f * this.m12 * _t17);
                d.rX = _buf0;
                d.rZ = _buf1;
            } else {
                if (this.m11 > 1.0f) {
                    float _buf0 = 0.5f * _t4 * _t15;
                    d.rY = 0.5f * (float) Math.sqrt(_t12);
                    float _buf1 = 0.5f * this.m12 * _t15;
                    d.rW = 0.5f * this.m02 * _t15;
                    d.rX = _buf0;
                    d.rZ = _buf1;
                } else {
                    float _buf0 = 0.5f * this.m02 * _t16;
                    d.rY = 0.5f * this.m12 * _t16;
                    float _buf1 = 0.5f * (float) Math.sqrt(_t13);
                    d.rW = 0.5f * _t5 * _t16;
                    d.rX = _buf0;
                    d.rZ = _buf1;
                }
            }
        }
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_general(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t1 = 1.0f - this.m00;
        float _t3 = this.m21 - this.m12;
        float _t4 = Math.max(this.m11, this.m22);
        float _t5 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t13 = this.m22 + (this.m00 + this.m11);
        float _t14 = 1.0f + _t13;
        float _t15 = this.m00 + (1.0f - this.m11 - this.m22);
        float _t16 = this.m11 + (_t1 - this.m22);
        float _t17 = this.m22 + (_t1 - this.m11);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            float _buf0 = 0.5f * _t3 * _t18;
            d.rY = 0.5f * _t7 * _t18;
            d.rZ = 0.5f * _t9 * _t18;
            d.rW = 0.5f * (float) Math.sqrt(_t14);
            d.rX = _buf0;
        } else {
            if (this.m00 > _t4) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t15);
                d.rY = 0.5f * _t5 * _t21;
                d.rZ = 0.5f * _t6 * _t21;
                d.rW = 0.5f * _t3 * _t21;
                d.rX = _buf0;
            } else {
                if (this.m11 > this.m22) {
                    float _buf0 = 0.5f * _t5 * _t19;
                    d.rY = 0.5f * (float) Math.sqrt(_t16);
                    d.rZ = 0.5f * _t8 * _t19;
                    d.rW = 0.5f * _t7 * _t19;
                    d.rX = _buf0;
                } else {
                    float _buf0 = 0.5f * _t6 * _t20;
                    d.rY = 0.5f * _t8 * _t20;
                    d.rZ = 0.5f * (float) Math.sqrt(_t17);
                    d.rW = 0.5f * _t9 * _t20;
                    d.rX = _buf0;
                }
            }
        }
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Convert this matrix (assumed orthonormal) to a pure-rotation dual quaternion and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat toDualQuat(@Mutated FloatDualQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toDualQuat_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toDualQuat_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return toDualQuat_orthogonal(dest);
        return toDualQuat_general(dest);
    }


    /**
     * Convert this matrix (assumed orthonormal) to a pure-rotation dual quaternion and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t1 = 1.0f - this.m00;
        float _t3 = this.m21 - this.m12;
        float _t4 = Math.max(this.m11, this.m22);
        float _t5 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t13 = this.m22 + (this.m00 + this.m11);
        float _t14 = 1.0f + _t13;
        float _t15 = this.m00 + (1.0f - this.m11 - this.m22);
        float _t16 = this.m11 + (_t1 - this.m22);
        float _t17 = this.m22 + (_t1 - this.m11);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            float _buf0 = 0.5f * _t3 * _t18;
            d.rY = 0.5f * _t7 * _t18;
            d.rZ = 0.5f * _t9 * _t18;
            d.rW = 0.5f * (float) Math.sqrt(_t14);
            d.rX = _buf0;
        } else {
            if (this.m00 > _t4) {
                float _buf0 = 0.5f * (float) Math.sqrt(_t15);
                d.rY = 0.5f * _t5 * _t21;
                d.rZ = 0.5f * _t6 * _t21;
                d.rW = 0.5f * _t3 * _t21;
                d.rX = _buf0;
            } else {
                if (this.m11 > this.m22) {
                    float _buf0 = 0.5f * _t5 * _t19;
                    d.rY = 0.5f * (float) Math.sqrt(_t16);
                    d.rZ = 0.5f * _t8 * _t19;
                    d.rW = 0.5f * _t7 * _t19;
                    d.rX = _buf0;
                } else {
                    float _buf0 = 0.5f * _t6 * _t20;
                    d.rY = 0.5f * _t8 * _t20;
                    d.rZ = 0.5f * (float) Math.sqrt(_t17);
                    d.rW = 0.5f * _t9 * _t20;
                    d.rX = _buf0;
                }
            }
        }
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_identity(@Mutated FloatRigid dest) {
        FloatRigidImpl d = (FloatRigidImpl) dest;
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        d.rX = 0.0f;
        d.rY = 0.0f;
        d.rZ = 0.0f;
        d.rW = 1.0f;
        return d;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_translation(@Mutated FloatRigid dest) {
        FloatRigidImpl d = (FloatRigidImpl) dest;
        float _t2 = (1.0f / (float) Math.sqrt(Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f))));
        float _t3 = Math.max(1.0f, _t2);
        float _t5 = this.m12 * _t2;
        float _t6 = this.m02 * _t2;
        float _t7 = _t2 < 0.0f ? -1.0f : 1.0f;
        float _t8 = 1.0f + _t7;
        float _t11 = _t8 + _t2;
        float _t13 = 2.0f - _t7 - _t2;
        float _t14 = (1.0f / (float) Math.sqrt(_t13));
        float _t15 = 1.0f + _t11;
        float _t16 = _t8 - 1.0f - _t2;
        float _t17 = 1.0f + _t2 - _t7 - 1.0f;
        float _t18 = (1.0f / (float) Math.sqrt(_t15));
        float _t19 = (1.0f / (float) Math.sqrt(_t17));
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        if (_t11 > 0.0f) {
            d.rX = -(0.5f * _t5 * _t18);
            d.rY = 0.5f * _t6 * _t18;
            d.rZ = 0.0f;
            d.rW = 0.5f * (float) Math.sqrt(_t15);
        } else {
            if (_t7 > _t3) {
                d.rX = 0.5f * (float) Math.sqrt(_t16);
                d.rY = 0.0f;
                d.rZ = 0.5f * _t6 * _t20;
                d.rW = -(0.5f * _t5 * _t20);
            } else {
                if (1.0f > _t2) {
                    d.rX = 0.0f;
                    d.rY = 0.5f * (float) Math.sqrt(_t13);
                    d.rZ = 0.5f * _t5 * _t14;
                    d.rW = 0.5f * _t6 * _t14;
                } else {
                    d.rX = 0.5f * _t6 * _t19;
                    d.rY = 0.5f * _t5 * _t19;
                    d.rZ = 0.5f * (float) Math.sqrt(_t17);
                    d.rW = 0.0f;
                }
            }
        }
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_general(@Mutated FloatRigid dest) {
        FloatRigidImpl d = (FloatRigidImpl) dest;
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))));
        float _t15 = this.m10 * _t14;
        float _t16 = this.m22 * _t13;
        float _t17 = this.m12 * _t13;
        float _t18 = this.m20 * _t14;
        float _t20 = this.m21 * _t12;
        float _t21 = this.m11 * _t12;
        float _t23 = this.m00 * _t14;
        float _t28 = Math.fma(this.m12, _t13, _t20);
        float _t32 = Math.fma(this.m21, _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), this.m01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), this.m02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(this.m01, _t12, _t45);
        float _t52 = Math.fma(this.m02, _t13, _t46);
        float _t53 = Math.fma(this.m02, _t13, -_t46);
        float _t54 = Math.fma(-this.m01, _t12, _t45);
        float _t59 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t44));
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            d.rX = 0.5f * _t32 * _t61;
            d.rY = 0.5f * _t53 * _t61;
            d.rZ = 0.5f * _t54 * _t61;
            d.rW = 0.5f * (float) Math.sqrt(_t60);
        } else {
            if (_t44 > _t33) {
                d.rX = 0.5f * (float) Math.sqrt(_t64);
                d.rY = 0.5f * _t51 * _t67;
                d.rZ = 0.5f * _t52 * _t67;
                d.rW = 0.5f * _t32 * _t67;
            } else {
                if (_t21 > _t16) {
                    d.rX = 0.5f * _t51 * _t65;
                    d.rY = 0.5f * (float) Math.sqrt(_t62);
                    d.rZ = 0.5f * _t28 * _t65;
                    d.rW = 0.5f * _t53 * _t65;
                } else {
                    d.rX = 0.5f * _t52 * _t66;
                    d.rY = 0.5f * _t28 * _t66;
                    d.rZ = 0.5f * (float) Math.sqrt(_t63);
                    d.rW = 0.5f * _t54 * _t66;
                }
            }
        }
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        return d;
    }


    /**
     * Extract this matrix's rotation into a rigid transform with zero translation (scale is removed
     * by normalizing the columns, but shear is not removed: a sheared block yields a rotation
     * quaternion that is not unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatRigid toRigid(@Mutated FloatRigid dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toRigid_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toRigid_translation(dest);
        return toRigid_general(dest);
    }


    /**
     * Extract this matrix's rotation into a rigid transform with zero translation (scale is removed
     * by normalizing the columns, but shear is not removed: a sheared block yields a rotation
     * quaternion that is not unit length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))));
        float _t15 = this.m10 * _t14;
        float _t16 = this.m22 * _t13;
        float _t17 = this.m12 * _t13;
        float _t18 = this.m20 * _t14;
        float _t20 = this.m21 * _t12;
        float _t21 = this.m11 * _t12;
        float _t23 = this.m00 * _t14;
        float _t28 = Math.fma(this.m12, _t13, _t20);
        float _t32 = Math.fma(this.m21, _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), this.m01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), this.m02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(this.m01, _t12, _t45);
        float _t52 = Math.fma(this.m02, _t13, _t46);
        float _t53 = Math.fma(this.m02, _t13, -_t46);
        float _t54 = Math.fma(-this.m01, _t12, _t45);
        float _t59 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t44));
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            d.rX = 0.5f * _t32 * _t61;
            d.rY = 0.5f * _t53 * _t61;
            d.rZ = 0.5f * _t54 * _t61;
            d.rW = 0.5f * (float) Math.sqrt(_t60);
        } else {
            if (_t44 > _t33) {
                d.rX = 0.5f * (float) Math.sqrt(_t64);
                d.rY = 0.5f * _t51 * _t67;
                d.rZ = 0.5f * _t52 * _t67;
                d.rW = 0.5f * _t32 * _t67;
            } else {
                if (_t21 > _t16) {
                    d.rX = 0.5f * _t51 * _t65;
                    d.rY = 0.5f * (float) Math.sqrt(_t62);
                    d.rZ = 0.5f * _t28 * _t65;
                    d.rW = 0.5f * _t53 * _t65;
                } else {
                    d.rX = 0.5f * _t52 * _t66;
                    d.rY = 0.5f * _t28 * _t66;
                    d.rZ = 0.5f * (float) Math.sqrt(_t63);
                    d.rW = 0.5f * _t54 * _t66;
                }
            }
        }
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        return d;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_identity(@Mutated FloatTransform dest) {
        FloatTransformImpl d = (FloatTransformImpl) dest;
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        d.rX = 0.0f;
        d.rY = 0.0f;
        d.rZ = 0.0f;
        d.rW = 1.0f;
        d.sX = 1.0f;
        d.sY = 1.0f;
        d.sZ = 1.0f;
        return d;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_translation(@Mutated FloatTransform dest) {
        FloatTransformImpl d = (FloatTransformImpl) dest;
        float _t1 = Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f));
        float _t2 = (1.0f / (float) Math.sqrt(_t1));
        float _t3 = Math.max(1.0f, _t2);
        float _t5 = this.m12 * _t2;
        float _t6 = this.m02 * _t2;
        float _t7 = _t2 < 0.0f ? -1.0f : 1.0f;
        float _t8 = 1.0f + _t7;
        float _t11 = _t8 + _t2;
        float _t13 = 2.0f - _t7 - _t2;
        float _t14 = (1.0f / (float) Math.sqrt(_t13));
        float _t15 = 1.0f + _t11;
        float _t16 = _t8 - 1.0f - _t2;
        float _t17 = 1.0f + _t2 - _t7 - 1.0f;
        float _t18 = (1.0f / (float) Math.sqrt(_t15));
        float _t19 = (1.0f / (float) Math.sqrt(_t17));
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        if (_t11 > 0.0f) {
            d.rX = -(0.5f * _t5 * _t18);
            d.rY = 0.5f * _t6 * _t18;
            d.rZ = 0.0f;
            d.rW = 0.5f * (float) Math.sqrt(_t15);
        } else {
            if (_t7 > _t3) {
                d.rX = 0.5f * (float) Math.sqrt(_t16);
                d.rY = 0.0f;
                d.rZ = 0.5f * _t6 * _t20;
                d.rW = -(0.5f * _t5 * _t20);
            } else {
                if (1.0f > _t2) {
                    d.rX = 0.0f;
                    d.rY = 0.5f * (float) Math.sqrt(_t13);
                    d.rZ = 0.5f * _t5 * _t14;
                    d.rW = 0.5f * _t6 * _t14;
                } else {
                    d.rX = 0.5f * _t6 * _t19;
                    d.rY = 0.5f * _t5 * _t19;
                    d.rZ = 0.5f * (float) Math.sqrt(_t17);
                    d.rW = 0.0f;
                }
            }
        }
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        d.sX = _t7;
        d.sY = 1.0f;
        d.sZ = (float) Math.sqrt(_t1);
        return d;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_general(@Mutated FloatTransform dest) {
        FloatTransformImpl d = (FloatTransformImpl) dest;
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t9 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t10 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t11 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t12 = (1.0f / (float) Math.sqrt(_t9));
        float _t13 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = (1.0f / (float) Math.sqrt(_t11));
        float _t15 = (float) Math.sqrt(_t11);
        float _t16 = this.m10 * _t14;
        float _t17 = this.m22 * _t13;
        float _t18 = this.m12 * _t13;
        float _t19 = this.m20 * _t14;
        float _t21 = this.m21 * _t12;
        float _t22 = this.m11 * _t12;
        float _t24 = this.m00 * _t14;
        float _t29 = Math.fma(this.m12, _t13, _t21);
        float _t33 = Math.fma(this.m21, _t12, -_t18);
        float _t34 = Math.max(_t22, _t17);
        float _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), this.m01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), this.m02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        float _t45, _t46, _t47;
        if (_t44 < 0.0f) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        float _t49 = 1.0f + _t45;
        float _t50 = 1.0f - _t45;
        float _t52 = Math.fma(this.m01, _t12, _t46);
        float _t53 = Math.fma(this.m02, _t13, _t47);
        float _t54 = Math.fma(this.m02, _t13, -_t47);
        float _t55 = Math.fma(-this.m01, _t12, _t46);
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t45));
        float _t61 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t49));
        float _t62 = (1.0f / (float) Math.sqrt(_t61));
        float _t63 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t50));
        float _t64 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t50));
        float _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        d.rX = _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67;
        d.rY = _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67;
        d.rZ = _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64);
        d.rW = _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67;
        d.sX = _t44 < 0.0f ? -_t15 : _t15;
        d.sY = (float) Math.sqrt(_t9);
        d.sZ = (float) Math.sqrt(_t10);
        return d;
    }


    /**
     * Decompose this matrix's linear {@code R * S} block into a TRS transform with zero translation
     * (scale is removed by normalizing the columns, but shear is not removed: a sheared block
     * yields a rotation quaternion that is not unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatTransform toTransform(@Mutated FloatTransform dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toTransform_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toTransform_translation(dest);
        return toTransform_general(dest);
    }


    /**
     * Decompose this matrix's linear {@code R * S} block into a TRS transform with zero translation
     * (scale is removed by normalizing the columns, but shear is not removed: a sheared block
     * yields a rotation quaternion that is not unit length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t9 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t10 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t11 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t12 = (1.0f / (float) Math.sqrt(_t9));
        float _t13 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = (1.0f / (float) Math.sqrt(_t11));
        float _t15 = (float) Math.sqrt(_t11);
        float _t16 = this.m10 * _t14;
        float _t17 = this.m22 * _t13;
        float _t18 = this.m12 * _t13;
        float _t19 = this.m20 * _t14;
        float _t21 = this.m21 * _t12;
        float _t22 = this.m11 * _t12;
        float _t24 = this.m00 * _t14;
        float _t29 = Math.fma(this.m12, _t13, _t21);
        float _t33 = Math.fma(this.m21, _t12, -_t18);
        float _t34 = Math.max(_t22, _t17);
        float _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), this.m01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), this.m02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        float _t45, _t46, _t47;
        if (_t44 < 0.0f) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        float _t49 = 1.0f + _t45;
        float _t50 = 1.0f - _t45;
        float _t52 = Math.fma(this.m01, _t12, _t46);
        float _t53 = Math.fma(this.m02, _t13, _t47);
        float _t54 = Math.fma(this.m02, _t13, -_t47);
        float _t55 = Math.fma(-this.m01, _t12, _t46);
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t45));
        float _t61 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t49));
        float _t62 = (1.0f / (float) Math.sqrt(_t61));
        float _t63 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t50));
        float _t64 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t50));
        float _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        d.tX = 0.0f;
        d.tY = 0.0f;
        d.tZ = 0.0f;
        d.rX = _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67;
        d.rY = _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67;
        d.rZ = _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64);
        d.rW = _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67;
        d.sX = _t44 < 0.0f ? -_t15 : _t15;
        d.sY = (float) Math.sqrt(_t9);
        d.sZ = (float) Math.sqrt(_t10);
        return d;
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private FloatQuat decomposeRotation_identity(@Mutated FloatQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private FloatQuat decomposeRotation_general(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t19 = -Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t20 = -Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t21 = Math.fma(_t19, _t7, this.m21);
        float _t22 = Math.fma(_t19, _t8, this.m01);
        float _t23 = Math.fma(_t19, _t9, this.m11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34, _t35, _t36;
        if (_t29 > 0.0f) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0f;
            _t35 = 0.0f;
            _t36 = 0.0f;
        }
        float _t40 = -Math.fma(Math.fma(_t20, _t7, this.m22), _t35, Math.fma(Math.fma(_t20, _t8, this.m02), _t34, Math.fma(_t20, _t9, this.m12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, this.m22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, this.m02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, this.m12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54, _t55, _t56;
        if (_t49 > 0.0f) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0f;
            _t55 = 0.0f;
            _t56 = 0.0f;
        }
        float _t60 = _t35 - _t54;
        float _t61 = Math.max(_t36, _t56);
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        float _t73, _t74, _t75;
        if (_t72 < 0.0f) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t90 = (1.0f / (float) Math.sqrt(_t86));
        float _t91 = (1.0f / (float) Math.sqrt(_t88));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        if (_t82 > 0.0f) {
            d.x = 0.5f * _t60 * _t90;
            d.y = 0.5f * _t81 * _t90;
            d.z = 0.5f * _t78 * _t90;
            d.w = 0.5f * (float) Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                d.x = 0.5f * (float) Math.sqrt(_t87);
                d.y = 0.5f * _t77 * _t93;
                d.z = 0.5f * _t80 * _t93;
                d.w = 0.5f * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    d.x = 0.5f * _t77 * _t91;
                    d.y = 0.5f * (float) Math.sqrt(_t88);
                    d.z = 0.5f * _t63 * _t91;
                    d.w = 0.5f * _t81 * _t91;
                } else {
                    d.x = 0.5f * _t80 * _t92;
                    d.y = 0.5f * _t63 * _t92;
                    d.z = 0.5f * (float) Math.sqrt(_t89);
                    d.w = 0.5f * _t78 * _t92;
                }
            }
        }
        return d;
    }


    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat decomposeRotation(@Mutated FloatQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeRotation_identity(dest);
        return decomposeRotation_general(dest);
    }


    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat decomposeRotation(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t19 = -Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t20 = -Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t21 = Math.fma(_t19, _t7, this.m21);
        float _t22 = Math.fma(_t19, _t8, this.m01);
        float _t23 = Math.fma(_t19, _t9, this.m11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34, _t35, _t36;
        if (_t29 > 0.0f) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0f;
            _t35 = 0.0f;
            _t36 = 0.0f;
        }
        float _t40 = -Math.fma(Math.fma(_t20, _t7, this.m22), _t35, Math.fma(Math.fma(_t20, _t8, this.m02), _t34, Math.fma(_t20, _t9, this.m12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, this.m22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, this.m02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, this.m12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54, _t55, _t56;
        if (_t49 > 0.0f) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0f;
            _t55 = 0.0f;
            _t56 = 0.0f;
        }
        float _t60 = _t35 - _t54;
        float _t61 = Math.max(_t36, _t56);
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        float _t73, _t74, _t75;
        if (_t72 < 0.0f) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t90 = (1.0f / (float) Math.sqrt(_t86));
        float _t91 = (1.0f / (float) Math.sqrt(_t88));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        if (_t82 > 0.0f) {
            d.x = 0.5f * _t60 * _t90;
            d.y = 0.5f * _t81 * _t90;
            d.z = 0.5f * _t78 * _t90;
            d.w = 0.5f * (float) Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                d.x = 0.5f * (float) Math.sqrt(_t87);
                d.y = 0.5f * _t77 * _t93;
                d.z = 0.5f * _t80 * _t93;
                d.w = 0.5f * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    d.x = 0.5f * _t77 * _t91;
                    d.y = 0.5f * (float) Math.sqrt(_t88);
                    d.z = 0.5f * _t63 * _t91;
                    d.w = 0.5f * _t81 * _t91;
                } else {
                    d.x = 0.5f * _t80 * _t92;
                    d.y = 0.5f * _t63 * _t92;
                    d.z = 0.5f * (float) Math.sqrt(_t89);
                    d.w = 0.5f * _t78 * _t92;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Float3 decomposeScale_identity(@Mutated Float3 dest) {
        return getScale_identity(dest);
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Float3 decomposeScale_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t4 = (float) Math.sqrt(_t2);
        float _t8, _t9, _t10;
        if (_t2 > 0.0f) {
            _t8 = this.m20 * _t3;
            _t9 = this.m00 * _t3;
            _t10 = this.m10 * _t3;
        } else {
            _t8 = 0.0f;
            _t9 = 0.0f;
            _t10 = 0.0f;
        }
        float _t17 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        float _t18 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        float _t19 = Math.fma(_t17, _t8, this.m21);
        float _t20 = Math.fma(_t17, _t9, this.m01);
        float _t21 = Math.fma(_t17, _t10, this.m11);
        float _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t38 = -Math.fma(Math.fma(_t18, _t8, this.m22), _t33, Math.fma(Math.fma(_t18, _t9, this.m02), _t32, Math.fma(_t18, _t10, this.m12) * _t34));
        float _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, this.m22));
        float _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, this.m02));
        float _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t52, _t53, _t54;
        if (_t47 > 0.0f) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0f;
            _t53 = 0.0f;
            _t54 = 0.0f;
        }
        d.x = Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4;
        d.y = (float) Math.sqrt(_t27);
        d.z = (float) Math.sqrt(_t47);
        return d;
    }


    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 decomposeScale(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeScale_identity(dest);
        return decomposeScale_general(dest);
    }


    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeScale(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t4 = (float) Math.sqrt(_t2);
        float _t8, _t9, _t10;
        if (_t2 > 0.0f) {
            _t8 = this.m20 * _t3;
            _t9 = this.m00 * _t3;
            _t10 = this.m10 * _t3;
        } else {
            _t8 = 0.0f;
            _t9 = 0.0f;
            _t10 = 0.0f;
        }
        float _t17 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        float _t18 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        float _t19 = Math.fma(_t17, _t8, this.m21);
        float _t20 = Math.fma(_t17, _t9, this.m01);
        float _t21 = Math.fma(_t17, _t10, this.m11);
        float _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t38 = -Math.fma(Math.fma(_t18, _t8, this.m22), _t33, Math.fma(Math.fma(_t18, _t9, this.m02), _t32, Math.fma(_t18, _t10, this.m12) * _t34));
        float _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, this.m22));
        float _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, this.m02));
        float _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t52, _t53, _t54;
        if (_t47 > 0.0f) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0f;
            _t53 = 0.0f;
            _t54 = 0.0f;
        }
        d.x = Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4;
        d.y = (float) Math.sqrt(_t27);
        d.z = (float) Math.sqrt(_t47);
        return d;
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_identity(@Mutated Float3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_translation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.m12;
        d.y = this.m02;
        d.z = 0.0f;
        return d;
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_general(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t14 = Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t15 = Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t16 = -_t14;
        float _t17 = -_t15;
        float _t19 = Math.fma(_t17, _t7, this.m21);
        float _t20 = Math.fma(_t17, _t8, this.m01);
        float _t21 = Math.fma(_t17, _t9, this.m11);
        float _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t28 = _t15 * _t27;
        float _t32, _t33, _t34;
        if (_t26 > 0.0f) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t37 = Math.fma(Math.fma(_t16, _t7, this.m22), _t32, Math.fma(Math.fma(_t16, _t8, this.m02), _t33, Math.fma(_t16, _t9, this.m12) * _t34));
        float _t38 = -_t37;
        float _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, this.m22));
        float _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, this.m02));
        float _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t49 = _t14 * _t48;
        float _t53, _t54, _t55;
        if (_t47 > 0.0f) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0f;
            _t54 = 0.0f;
            _t55 = 0.0f;
        }
        float _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0f) {
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
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 decomposeSkew(@Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return decomposeSkew_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeSkew_translation(dest);
        return decomposeSkew_general(dest);
    }


    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix) and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeSkew(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t14 = Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t15 = Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t16 = -_t14;
        float _t17 = -_t15;
        float _t19 = Math.fma(_t17, _t7, this.m21);
        float _t20 = Math.fma(_t17, _t8, this.m01);
        float _t21 = Math.fma(_t17, _t9, this.m11);
        float _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t28 = _t15 * _t27;
        float _t32, _t33, _t34;
        if (_t26 > 0.0f) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t37 = Math.fma(Math.fma(_t16, _t7, this.m22), _t32, Math.fma(Math.fma(_t16, _t8, this.m02), _t33, Math.fma(_t16, _t9, this.m12) * _t34));
        float _t38 = -_t37;
        float _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, this.m22));
        float _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, this.m02));
        float _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t49 = _t14 * _t48;
        float _t53, _t54, _t55;
        if (_t47 > 0.0f) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0f;
            _t54 = 0.0f;
            _t55 = 0.0f;
        }
        float _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0f) {
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
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Float3x3 makeIdentity() {
        this.m00 = 1.0f;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = 1.0f;
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
        this.properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_general(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - this.m00, this.m00);
        d.m10 = Math.fma(t, other.m10() - this.m10, this.m10);
        d.m20 = Math.fma(t, other.m20() - this.m20, this.m20);
        d.m01 = Math.fma(t, other.m01() - this.m01, this.m01);
        d.m11 = Math.fma(t, other.m11() - this.m11, this.m11);
        d.m21 = Math.fma(t, other.m21() - this.m21, this.m21);
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = Math.fma(t, other.m22() - this.m22, this.m22);
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0f, 1.0f);
        d.m10 = t * other.m10();
        d.m20 = t * other.m20();
        d.m01 = t * other.m01();
        d.m11 = Math.fma(t, other.m11() - 1.0f, 1.0f);
        d.m21 = t * other.m21();
        d.m02 = t * other.m02();
        d.m12 = t * other.m12();
        d.m22 = Math.fma(t, other.m22() - 1.0f, 1.0f);
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0f, 1.0f);
        d.m10 = t * other.m10();
        d.m20 = t * other.m20();
        d.m01 = t * other.m01();
        d.m11 = Math.fma(t, other.m11() - 1.0f, 1.0f);
        d.m21 = t * other.m21();
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = Math.fma(t, other.m22() - 1.0f, 1.0f);
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - this.m00, this.m00);
        d.m10 = Math.fma(t, other.m10() - this.m10, this.m10);
        d.m20 = t * other.m20();
        d.m01 = Math.fma(t, other.m01() - this.m01, this.m01);
        d.m11 = Math.fma(t, other.m11() - this.m11, this.m11);
        d.m21 = t * other.m21();
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = Math.fma(t, other.m22() - 1.0f, 1.0f);
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_identity(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_translation(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = t * other.m02();
        d.m12 = t * other.m12();
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_affine(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0f, 1.0f);
        d.m10 = t * other.m10();
        d.m20 = 0.0f;
        d.m01 = t * other.m01();
        d.m11 = Math.fma(t, other.m11() - 1.0f, 1.0f);
        d.m21 = 0.0f;
        d.m02 = t * other.m02();
        d.m12 = t * other.m12();
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_identity(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-t, this.m02, this.m02);
        d.m12 = Math.fma(-t, this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_translation(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_affine(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0f, 1.0f);
        d.m10 = t * other.m10();
        d.m20 = 0.0f;
        d.m01 = t * other.m01();
        d.m11 = Math.fma(t, other.m11() - 1.0f, 1.0f);
        d.m21 = 0.0f;
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_identity(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t1 = Math.fma(-t, this.m11, t + this.m11);
        d.m00 = _t1;
        float _buf0 = Math.fma(-t, this.m10, this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(t, this.m10, -this.m10);
        d.m11 = _t1;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-t, this.m02, this.m02);
        d.m12 = Math.fma(-t, this.m12, this.m12);
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_translation(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, 1.0f - this.m00, this.m00);
        d.m10 = Math.fma(-t, this.m10, this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(-t, this.m01, this.m01);
        d.m11 = Math.fma(t, 1.0f - this.m11, this.m11);
        d.m21 = 0.0f;
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_affine(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - this.m00, this.m00);
        d.m10 = Math.fma(t, other.m10() - this.m10, this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(t, other.m01() - this.m01, this.m01);
        d.m11 = Math.fma(t, other.m11() - this.m11, this.m11);
        d.m21 = 0.0f;
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_affine_identity(Float3x3R other, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, 1.0f - this.m00, this.m00);
        d.m10 = Math.fma(-t, this.m10, this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(-t, this.m01, this.m01);
        d.m11 = Math.fma(t, 1.0f - this.m11, this.m11);
        d.m21 = 0.0f;
        d.m02 = Math.fma(-t, this.m02, this.m02);
        d.m12 = Math.fma(-t, this.m12, this.m12);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
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
    public Float3x3 lerp(Float3x3R other, float t, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_identity_affine(other, t, dest);
            return lerp_identity(other, t, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_translation_affine(other, t, dest);
            return lerp_translation(other, t, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_orthogonal_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, dest);
            return lerp_orthogonal(other, t, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, dest);
            return lerp_orthogonal(other, t, dest);
        }
        return lerp_general(other, t, dest);
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 lerp(Float3x3R other, float t) {
        if (Joml.RETURN_NEW) return lerp(other, t, Joml.float3x3());
        int p = this.properties;
        int q = ((Float3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_identity_affine(other, t, this);
            return lerp_identity(other, t, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_translation_affine(other, t, this);
            return lerp_translation(other, t, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_orthogonal_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, this);
            return lerp_orthogonal(other, t, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, this);
            return lerp_orthogonal(other, t, this);
        }
        return lerp_general(other, t, this);
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lerp(Float3x3R other, float t, @Mutated Double3x3 dest) {
        return lerp(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), other.m20(), other.m21(), other.m22(), t, dest);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 lerp(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, float t, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(t, m00 - this.m00, this.m00);
        d.m10 = Math.fma(t, m10 - this.m10, this.m10);
        d.m20 = Math.fma(t, m20 - this.m20, this.m20);
        d.m01 = Math.fma(t, m01 - this.m01, this.m01);
        d.m11 = Math.fma(t, m11 - this.m11, this.m11);
        d.m21 = Math.fma(t, m21 - this.m21, this.m21);
        d.m02 = Math.fma(t, m02 - this.m02, this.m02);
        d.m12 = Math.fma(t, m12 - this.m12, this.m12);
        d.m22 = Math.fma(t, m22 - this.m22, this.m22);
        d.properties = 0;
        return d;
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lerp(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, float t, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = Math.fma(t, m00 - this.m00, this.m00);
        d.m10 = Math.fma(t, m10 - this.m10, this.m10);
        d.m20 = Math.fma(t, m20 - this.m20, this.m20);
        d.m01 = Math.fma(t, m01 - this.m01, this.m01);
        d.m11 = Math.fma(t, m11 - this.m11, this.m11);
        d.m21 = Math.fma(t, m21 - this.m21, this.m21);
        d.m02 = Math.fma(t, m02 - this.m02, this.m02);
        d.m12 = Math.fma(t, m12 - this.m12, this.m12);
        d.m22 = Math.fma(t, m22 - this.m22, this.m22);
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        float _buf1 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        float _buf2 = Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21));
        float _buf3 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        float _buf4 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        float _buf5 = Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21));
        float _buf6 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        float _buf7 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m22 = Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(right.m20(), this.m02, right.m00());
        d.m10 = Math.fma(right.m20(), this.m12, right.m10());
        d.m20 = right.m20();
        d.m01 = Math.fma(right.m21(), this.m02, right.m01());
        d.m11 = Math.fma(right.m21(), this.m12, right.m11());
        d.m21 = right.m21();
        d.m02 = Math.fma(right.m22(), this.m02, right.m02());
        d.m12 = Math.fma(right.m22(), this.m12, right.m12());
        d.m22 = right.m22();
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m11, -(right.m10() * this.m10)));
        float _buf1 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        d.m20 = right.m20();
        float _buf2 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m11, -(right.m11() * this.m10)));
        float _buf3 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        d.m21 = right.m21();
        float _buf4 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m11, -(right.m12() * this.m10)));
        d.m12 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m22 = right.m22();
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        float _buf1 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        d.m20 = right.m20();
        float _buf2 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        float _buf3 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        d.m21 = right.m21();
        float _buf4 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        d.m12 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m22 = right.m22();
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_translation(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = right.m02() + this.m02;
        d.m12 = right.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_affine(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m20 = 0.0f;
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m21 = 0.0f;
        d.m02 = right.m02() + this.m02;
        d.m12 = right.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_translation(Float3x3R right, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        d.m20 = 0.0f;
        float _buf2 = this.m01;
        float _buf3 = this.m11;
        d.m21 = 0.0f;
        float _buf4 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_affine(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m11, -(right.m10() * this.m10));
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(right.m01(), this.m11, -(right.m11() * this.m10));
        float _buf3 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        float _buf4 = Math.fma(-right.m12(), this.m10, Math.fma(right.m02(), this.m11, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine_affine(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        float _buf3 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        float _buf4 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_translation(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        float _buf2 = this.m20;
        float _buf3 = this.m01;
        float _buf4 = this.m11;
        float _buf5 = this.m21;
        float _buf6 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        float _buf7 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_affine(Float3x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        float _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        float _buf3 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        float _buf4 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        float _buf5 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        float _buf6 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        float _buf7 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = 0;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 mul(Float3x3R right, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Float3x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_orthogonal_affine(right, dest);
            return mul_orthogonal(right, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_affine(right, dest);
            return mul_affine(right, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_general_affine(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 mul(Float3x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(right);
        int q = ((Float3x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_orthogonal_affine(right, this);
            return mul_orthogonal(right, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_affine(right, this);
            return mul_affine(right, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_general_affine(right, this);
        return mul_general(right, this);
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(Float3x3R right, @Mutated Double3x3 dest) {
        return mul(right.m00(), right.m01(), right.m02(), right.m10(), right.m11(), right.m12(), right.m20(), right.m21(), right.m22(), dest);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 mul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _buf1 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _buf2 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _buf3 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _buf4 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _buf5 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        d.m02 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        d.m12 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        d.m22 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _buf1 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _buf2 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _buf3 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _buf4 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _buf5 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        d.m02 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        d.m12 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        d.m22 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m20 = 0.0f;
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity_self(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m20 = 0.0f;
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_self(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(right.m00(), this.m11, -(right.m10() * this.m10));
        float _buf0 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        d.m01 = Math.fma(right.m01(), this.m11, -(right.m11() * this.m10));
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_self(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(right.m00(), this.m11, -(right.m10() * this.m10));
        float _buf0 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m01 = Math.fma(right.m01(), this.m11, -(right.m11() * this.m10));
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m10 = _buf0;
        d.properties = (((Float2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine_self(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float2x2R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        float _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
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
    public Float3x3 mul(Float2x2R right, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine(right, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 mul(Float2x2R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity_self(right, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_self(right, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal_self(right, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_self(right, this);
        return mul_general(right, this);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(Float2x2R right, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        float _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        float _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        float _buf3 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        float _buf4 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        float _buf5 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m20 = 0.0f;
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m21 = 0.0f;
        d.m02 = right.m02();
        d.m12 = right.m12();
        d.m22 = 1.0f;
        d.properties = ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = right.m00();
        d.m10 = right.m10();
        d.m20 = 0.0f;
        d.m01 = right.m01();
        d.m11 = right.m11();
        d.m21 = 0.0f;
        d.m02 = right.m02() + this.m02;
        d.m12 = right.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(right.m00(), this.m11, -(right.m10() * this.m10));
        float _buf0 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        d.m01 = Math.fma(right.m01(), this.m11, -(right.m11() * this.m10));
        float _buf1 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        d.m02 = Math.fma(-right.m12(), this.m10, Math.fma(right.m02(), this.m11, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        float _buf3 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m21 = 0.0f;
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE & ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity_translation(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = right.m02();
        d.m12 = right.m12();
        d.m22 = 1.0f;
        d.properties = ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_translation(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = right.m02() + this.m02;
        d.m12 = right.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float2x3Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_translation(Float2x3R right, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        d.m20 = 0.0f;
        float _buf2 = this.m01;
        float _buf3 = this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_translation(Float2x3R right, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        float _buf2 = this.m20;
        float _buf3 = this.m01;
        float _buf4 = this.m11;
        float _buf5 = this.m21;
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 mul(Float2x3R right, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_identity_translation(right, dest);
            return mul_identity(right, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
            return mul_affine(right, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 mul(Float2x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.float3x3());
        int p = this.properties;
        int q = ((Float2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_identity_translation(right, this);
            return mul_identity(right, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
            return mul_affine(right, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, this);
        return mul_general(right, this);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(Float2x3R right, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        float _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        float _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        float _buf3 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        float _buf4 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        float _buf5 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        float _buf1 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        float _buf2 = Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10));
        float _buf3 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        float _buf4 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        float _buf5 = Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11));
        float _buf6 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        float _buf7 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m22 = Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = other.m00();
        float _buf1 = other.m10();
        float _buf2 = other.m20();
        float _buf3 = other.m01();
        float _buf4 = other.m11();
        float _buf5 = other.m21();
        float _buf6 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        float _buf7 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22()));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m11, other.m01() * this.m10);
        float _buf1 = Math.fma(other.m10(), this.m11, other.m11() * this.m10);
        float _buf2 = Math.fma(other.m20(), this.m11, other.m21() * this.m10);
        float _buf3 = Math.fma(other.m01(), this.m11, -(other.m00() * this.m10));
        float _buf4 = Math.fma(other.m11(), this.m11, -(other.m10() * this.m10));
        float _buf5 = Math.fma(other.m21(), this.m11, -(other.m20() * this.m10));
        float _buf6 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        float _buf7 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22()));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        float _buf1 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        float _buf2 = Math.fma(other.m20(), this.m00, other.m21() * this.m10);
        float _buf3 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        float _buf4 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        float _buf5 = Math.fma(other.m20(), this.m01, other.m21() * this.m11);
        float _buf6 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        float _buf7 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22()));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = other.m00();
        float _buf1 = other.m10();
        d.m20 = 0.0f;
        float _buf2 = other.m01();
        float _buf3 = other.m11();
        d.m21 = 0.0f;
        float _buf4 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_TRANSLATION & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_translation(Float3x3R other, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m11, other.m01() * this.m10);
        float _buf1 = Math.fma(other.m10(), this.m11, other.m11() * this.m10);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(other.m01(), this.m11, -(other.m00() * this.m10));
        float _buf3 = Math.fma(other.m11(), this.m11, -(other.m10() * this.m10));
        d.m21 = 0.0f;
        float _buf4 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        float _buf1 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        float _buf3 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m21 = 0.0f;
        float _buf4 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE & ((Float3x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_translation(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(other.m02(), this.m20, this.m00);
        d.m10 = Math.fma(other.m12(), this.m20, this.m10);
        d.m20 = this.m20;
        d.m01 = Math.fma(other.m02(), this.m21, this.m01);
        d.m11 = Math.fma(other.m12(), this.m21, this.m11);
        d.m21 = this.m21;
        d.m02 = Math.fma(other.m02(), this.m22, this.m02);
        d.m12 = Math.fma(other.m12(), this.m22, this.m12);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_affine(Float3x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        float _buf1 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        d.m20 = this.m20;
        float _buf2 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        float _buf3 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        d.m21 = this.m21;
        float _buf4 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        d.m12 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.properties = 0;
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
    public Float3x3 preMul(Float3x3R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Float3x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_orthogonal_affine(other, dest);
            return preMul_orthogonal(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_affine(other, dest);
            return preMul_affine(other, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_general_affine(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preMul(Float3x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(other);
        int q = ((Float3x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_orthogonal_affine(other, this);
            return preMul_orthogonal(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_affine(other, this);
            return preMul_affine(other, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_general_affine(other, this);
        return preMul_general(other, this);
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Float3x3R other, @Mutated Double3x3 dest) {
        return preMul(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), other.m20(), other.m21(), other.m22(), dest);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preMul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(m02, this.m20, Math.fma(m00, this.m00, m01 * this.m10));
        float _buf1 = Math.fma(m12, this.m20, Math.fma(m10, this.m00, m11 * this.m10));
        d.m20 = Math.fma(m22, this.m20, Math.fma(m20, this.m00, m21 * this.m10));
        float _buf2 = Math.fma(m02, this.m21, Math.fma(m00, this.m01, m01 * this.m11));
        float _buf3 = Math.fma(m12, this.m21, Math.fma(m10, this.m01, m11 * this.m11));
        d.m21 = Math.fma(m22, this.m21, Math.fma(m20, this.m01, m21 * this.m11));
        float _buf4 = Math.fma(m02, this.m22, Math.fma(m00, this.m02, m01 * this.m12));
        float _buf5 = Math.fma(m12, this.m22, Math.fma(m10, this.m02, m11 * this.m12));
        d.m22 = Math.fma(m22, this.m22, Math.fma(m20, this.m02, m21 * this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(m02, this.m20, Math.fma(m00, this.m00, m01 * this.m10));
        float _buf1 = Math.fma(m12, this.m20, Math.fma(m10, this.m00, m11 * this.m10));
        d.m20 = Math.fma(m22, this.m20, Math.fma(m20, this.m00, m21 * this.m10));
        float _buf2 = Math.fma(m02, this.m21, Math.fma(m00, this.m01, m01 * this.m11));
        float _buf3 = Math.fma(m12, this.m21, Math.fma(m10, this.m01, m11 * this.m11));
        d.m21 = Math.fma(m22, this.m21, Math.fma(m20, this.m01, m21 * this.m11));
        float _buf4 = Math.fma(m02, this.m22, Math.fma(m00, this.m02, m01 * this.m12));
        float _buf5 = Math.fma(m12, this.m22, Math.fma(m10, this.m02, m11 * this.m12));
        d.m22 = Math.fma(m22, this.m22, Math.fma(m20, this.m02, m21 * this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = other.m11();
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity_self(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m01 = other.m01();
        d.m11 = other.m11();
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = other.m11();
        d.m21 = 0.0f;
        float _buf0 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m22 = 1.0f;
        d.m02 = _buf0;
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_self(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m01 = other.m01();
        d.m11 = other.m11();
        float _buf0 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m02 = _buf0;
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(other.m00(), this.m11, other.m01() * this.m10);
        float _buf0 = Math.fma(other.m10(), this.m11, other.m11() * this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(other.m01(), this.m11, -(other.m00() * this.m10));
        d.m11 = Math.fma(other.m11(), this.m11, -(other.m10() * this.m10));
        d.m21 = 0.0f;
        float _buf1 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m02 = _buf1;
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_self(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(other.m00(), this.m11, other.m01() * this.m10);
        float _buf0 = Math.fma(other.m10(), this.m11, other.m11() * this.m10);
        d.m01 = Math.fma(other.m01(), this.m11, -(other.m00() * this.m10));
        d.m11 = Math.fma(other.m11(), this.m11, -(other.m10() * this.m10));
        float _buf1 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m10 = _buf0;
        d.m02 = _buf1;
        d.properties = (((Float2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m20 = 0.0f;
        float _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m21 = 0.0f;
        float _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine_self(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        float _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        float _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float2x2R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m20 = this.m20;
        float _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m21 = this.m21;
        float _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
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
    public Float3x3 preMul(Float2x2R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine(other, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preMul(Float2x2R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity_self(other, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_self(other, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal_self(other, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_self(other, this);
        return preMul_general(other, this);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Float2x2R other, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m20 = this.m20;
        float _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m21 = this.m21;
        float _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        d.m10 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        d.m20 = this.m20;
        float _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        d.m11 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        d.m21 = this.m21;
        float _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        d.m12 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = other.m11();
        d.m21 = 0.0f;
        d.m02 = other.m02();
        d.m12 = other.m12();
        d.m22 = 1.0f;
        d.properties = ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = other.m00();
        d.m10 = other.m10();
        d.m20 = 0.0f;
        d.m01 = other.m01();
        d.m11 = other.m11();
        d.m21 = 0.0f;
        float _buf0 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m02 = _buf0;
        d.properties = Joml.BIT_TRANSLATION & ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(other.m00(), this.m11, other.m01() * this.m10);
        float _buf0 = Math.fma(other.m10(), this.m11, other.m11() * this.m10);
        d.m20 = 0.0f;
        d.m01 = Math.fma(other.m01(), this.m11, -(other.m00() * this.m10));
        d.m11 = Math.fma(other.m11(), this.m11, -(other.m10() * this.m10));
        d.m21 = 0.0f;
        float _buf1 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.m02 = _buf1;
        d.properties = Joml.BIT_ORTHOGONAL & ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m20 = 0.0f;
        float _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m21 = 0.0f;
        float _buf2 = Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02()));
        d.m12 = Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12()));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_AFFINE & ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity_translation(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = other.m02();
        d.m12 = other.m12();
        d.m22 = 1.0f;
        d.properties = ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_translation(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION & ((Float2x3Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_translation(Float2x3R other, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = 1.0f;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_translation(Float2x3R other, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(other.m02(), this.m20, this.m00);
        d.m10 = Math.fma(other.m12(), this.m20, this.m10);
        d.m20 = this.m20;
        d.m01 = Math.fma(other.m02(), this.m21, this.m01);
        d.m11 = Math.fma(other.m12(), this.m21, this.m11);
        d.m21 = this.m21;
        d.m02 = Math.fma(other.m02(), this.m22, this.m02);
        d.m12 = Math.fma(other.m12(), this.m22, this.m12);
        d.m22 = this.m22;
        d.properties = 0;
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
    public Float3x3 preMul(Float2x3R other, @Mutated Float3x3 dest) {
        int p = this.properties;
        int q = ((Float2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_identity_translation(other, dest);
            return preMul_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
            return preMul_affine(other, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preMul(Float2x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.float3x3());
        int p = this.properties;
        int q = ((Float2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_identity_translation(other, this);
            return preMul_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
            return preMul_affine(other, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, this);
        return preMul_general(other, this);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Float2x3R other, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        d.m10 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        d.m20 = this.m20;
        float _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        d.m11 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        d.m21 = this.m21;
        float _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        d.m12 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Set this matrix to the outer product of {@code col} and {@code row}.
     *
     * @param col the column vector (left operand)
     * @param row the row vector (right operand)
     * @return this
     */
    public @Mutated Float3x3 makeOuterProduct(Float3R col, Float3R row) {
        return makeOuterProduct(col.x(), col.y(), col.z(), row.x(), row.y(), row.z());
    }


    /**
     * Set this matrix to the outer product of ({@code colX}, {@code colY}, {@code colZ}) and
     * ({@code rowX}, {@code rowY}, {@code rowZ}).
     *
     * @param colX the {@code x} component of the vector {@code (colX, colY, colZ)}
     * @param colY the {@code y} component of the vector {@code (colX, colY, colZ)}
     * @param colZ the {@code z} component of the vector {@code (colX, colY, colZ)}
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @return this
     */
    @Mutated public Float3x3 makeOuterProduct(float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        this.m00 = colX * rowX;
        this.m10 = colY * rowX;
        this.m20 = colZ * rowX;
        this.m01 = colX * rowY;
        this.m11 = colY * rowY;
        this.m21 = colZ * rowY;
        this.m02 = colX * rowZ;
        this.m12 = colY * rowZ;
        this.m22 = colZ * rowZ;
        this.properties = 0;
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
    public Float3x3 lookAlong(Float3R dir, Float3R up, @Mutated Float3x3 dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lookAlong(Float3R dir, Float3R up, @Mutated Double3x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 lookAlong(Float3R dir, Float3R up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
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
    public Float3x3 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        float _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        float _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        float _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        float _buf0 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28));
        float _buf1 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28));
        float _buf2 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28));
        float _buf3 = Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37));
        float _buf4 = Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37));
        float _buf5 = Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37));
        d.m02 = Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7));
        d.m12 = Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7));
        d.m22 = Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3x3 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        float _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        float _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        float _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        float _buf0 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28));
        float _buf1 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28));
        float _buf2 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28));
        float _buf3 = Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37));
        float _buf4 = Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37));
        float _buf5 = Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37));
        d.m02 = Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7));
        d.m12 = Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7));
        d.m22 = Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Set this matrix to the rotation part of the unit dual quaternion {@code dq} (the encoded
     * translation is dropped).
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return this
     */
    public @Mutated Float3x3 makeFromDualQuat(FloatDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this matrix to the rotation part of the unit dual quaternion ({@code dqRX}, {@code dqRY},
     * {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ}, {@code dqDW}) (the
     * encoded translation is dropped).
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
    @Mutated public Float3x3 makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        this.m00 = Math.fma(-2.0f, _t0, _t6);
        this.m10 = 2.0f * Math.fma(dqRX, dqRY, _t2);
        this.m20 = Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ);
        this.m01 = Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY);
        this.m11 = Math.fma(-2.0f, _t4, _t6);
        this.m21 = 2.0f * Math.fma(dqRX, dqRW, _t5);
        this.m02 = 2.0f * Math.fma(dqRX, dqRZ, _t3);
        this.m12 = Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5);
        this.m22 = Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f));
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Float3x3 makeRotation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        this.m00 = _t0;
        this.m10 = _t1;
        this.m20 = 0.0f;
        this.m01 = -_t1;
        this.m11 = _t0;
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Float3x3 makeRotationAxis(float angle, Float3R axis) {
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
    @Mutated public Float3x3 makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        this.m00 = Math.fma(_t2, axisX * axisX, _t0);
        this.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        this.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        this.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        this.m11 = Math.fma(_t2, axisY * axisY, _t0);
        this.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        this.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        this.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        this.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Float3x3 makeRotationLookAlong(Float3R dir, Float3R up) {
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
    @Mutated public Float3x3 makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        this.m00 = _t26;
        this.m10 = _t28;
        this.m20 = _t27;
        this.m01 = Math.fma(_t7, _t27, -(_t9 * _t28));
        this.m11 = Math.fma(_t9, _t26, -(_t8 * _t27));
        this.m21 = Math.fma(_t8, _t28, -(_t7 * _t26));
        this.m02 = _t8;
        this.m12 = _t7;
        this.m22 = _t9;
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    public @Mutated Float3x3 makeRotationQuat(FloatQuatR q) {
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
    @Mutated public Float3x3 makeRotationQuat(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        this.m00 = Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f);
        this.m10 = 2.0f * Math.fma(qX, qY, _t1);
        this.m20 = 2.0f * Math.fma(qX, qZ, -_t2);
        this.m01 = 2.0f * Math.fma(qX, qY, -_t1);
        this.m11 = Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f);
        this.m21 = 2.0f * Math.fma(qX, qW, qY * qZ);
        this.m02 = 2.0f * Math.fma(qX, qZ, _t2);
        this.m12 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        this.m22 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Float3x3 makeRotationX(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        this.m00 = 1.0f;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = _t0;
        this.m21 = _t1;
        this.m02 = 0.0f;
        this.m12 = -_t1;
        this.m22 = _t0;
        this.properties = 0;
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
    @Mutated public Float3x3 makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        this.m00 = _t0 * _t1;
        this.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        this.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        this.m01 = -(_t2 * _t0);
        this.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        this.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        this.m02 = _t3;
        this.m12 = -(_t4 * _t0);
        this.m22 = _t5 * _t0;
        this.properties = 0;
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
    @Mutated public Float3x3 makeRotationXZY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        this.m00 = _t0 * _t1;
        this.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        this.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        this.m01 = -_t2;
        this.m11 = _t4 * _t1;
        this.m21 = _t5 * _t1;
        this.m02 = _t3 * _t1;
        this.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        this.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Float3x3 makeRotationY(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        this.m00 = _t0;
        this.m10 = 0.0f;
        this.m20 = -_t1;
        this.m01 = 0.0f;
        this.m11 = 1.0f;
        this.m21 = 0.0f;
        this.m02 = _t1;
        this.m12 = 0.0f;
        this.m22 = _t0;
        this.properties = 0;
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
    @Mutated public Float3x3 makeRotationYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        this.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        this.m10 = _t2 * _t5;
        this.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        this.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        this.m11 = _t5 * _t4;
        this.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        this.m02 = _t1 * _t5;
        this.m12 = -_t0;
        this.m22 = _t5 * _t3;
        this.properties = 0;
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
    @Mutated public Float3x3 makeRotationYZX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        this.m00 = _t0 * _t1;
        this.m10 = _t4;
        this.m20 = -(_t3 * _t1);
        this.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        this.m11 = _t5 * _t1;
        this.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        this.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        this.m12 = -(_t2 * _t1);
        this.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Float3x3 makeRotationZ(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        this.m00 = _t0;
        this.m10 = _t1;
        this.m20 = 0.0f;
        this.m01 = -_t1;
        this.m11 = _t0;
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
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
    @Mutated public Float3x3 makeRotationZXY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        this.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        this.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        this.m20 = -(_t4 * _t5);
        this.m01 = -(_t3 * _t5);
        this.m11 = _t5 * _t1;
        this.m21 = _t2;
        this.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        this.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        this.m22 = _t5 * _t0;
        this.properties = 0;
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
    @Mutated public Float3x3 makeRotationZYX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        this.m00 = _t0 * _t1;
        this.m10 = _t4 * _t0;
        this.m20 = -_t2;
        this.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        this.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        this.m21 = _t3 * _t0;
        this.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        this.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        this.m22 = _t5 * _t0;
        this.properties = 0;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Float3x3 makeScaling(Float2R v) {
        return makeScaling(v.x(), v.y());
    }


    /**
     * Set this matrix to a scaling transformation that scales by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Float3x3 makeScaling(float vX, float vY) {
        this.m00 = vX;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = vY;
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code s} of the x and y axes only
     * (the 2D homogeneous {@code diag(s, s, 1)}: the third row and column are left unscaled).
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Float3x3 makeScaling(float s) {
        this.m00 = s;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = s;
        this.m21 = 0.0f;
        this.m02 = 0.0f;
        this.m12 = 0.0f;
        this.m22 = 1.0f;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Float3x3 makeTranslation(Float2R v) {
        return makeTranslation(v.x(), v.y());
    }


    /**
     * Set this matrix to a translation transformation that translates by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return this
     */
    @Mutated public Float3x3 makeTranslation(float vX, float vY) {
        this.m00 = 1.0f;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = 1.0f;
        this.m21 = 0.0f;
        this.m02 = vX;
        this.m12 = vY;
        this.m22 = 1.0f;
        this.properties = Joml.BIT_TRANSLATION;
        return this;
    }


    /**
     * Set this matrix to the 2D view transformation that maps the rectangle
     * {@code [left, right] x [bottom, top]} onto {@code [-1, +1] x [-1, +1]}.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this
     */
    @Mutated public Float3x3 makeView(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        this.m00 = 2.0f * _t0_inv;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = 2.0f * _t1_inv;
        this.m21 = 0.0f;
        this.m02 = -((left + right) * _t0_inv);
        this.m12 = -((bottom + top) * _t1_inv);
        this.m22 = 1.0f;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_orthogonal_affine(float angle, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        d.m20 = 0.0f;
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        d.m21 = 0.0f;
        float _buf2 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_orthogonal_affine_self(float angle, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        float _buf2 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_identity(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_identity_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        float _buf0 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m22 = 1.0f;
        d.m02 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        float _buf0 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m02 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        d.m20 = this.m20;
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        d.m21 = this.m21;
        float _buf2 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preRotate(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_orthogonal_affine(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotate_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotate(float angle) {
        if (Joml.RETURN_NEW) return preRotate(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_orthogonal_affine_self(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotate_general(angle, this);
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotate(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        d.m20 = this.m20;
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        d.m21 = this.m21;
        float _buf2 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preRotateAround(float angle, Float2R pivot, @Mutated Float3x3 dest) {
        return preRotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAround(float angle, Float2R pivot, @Mutated Double3x3 dest) {
        return preRotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preRotateAround(float angle, Float2R pivot) {
        return preRotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_orthogonal_affine(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        d.m20 = 0.0f;
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        d.m21 = 0.0f;
        float _buf2 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_orthogonal_affine_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        float _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        float _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        float _buf2 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_identity(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = Math.fma(pivotX, _t5, pivotY * _t1);
        d.m12 = Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_identity_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m02 = Math.fma(pivotX, _t5, pivotY * _t1);
        d.m12 = Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_translation(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        float _buf0 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.m22 = 1.0f;
        d.m02 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_translation_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        float _buf0 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(this.m02, _t0, -(this.m12 * _t1));
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        d.m02 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_general(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t0);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t0));
        float _buf0 = Math.fma(this.m20, _t9, Math.fma(this.m00, _t1, -(this.m10 * _t0)));
        d.m10 = Math.fma(this.m20, _t10, Math.fma(this.m00, _t0, this.m10 * _t1));
        d.m20 = this.m20;
        float _buf1 = Math.fma(this.m21, _t9, Math.fma(this.m01, _t1, -(this.m11 * _t0)));
        d.m11 = Math.fma(this.m21, _t10, Math.fma(this.m01, _t0, this.m11 * _t1));
        d.m21 = this.m21;
        float _buf2 = Math.fma(this.m22, _t9, Math.fma(this.m02, _t1, -(this.m12 * _t0)));
        d.m12 = Math.fma(this.m22, _t10, Math.fma(this.m02, _t0, this.m12 * _t1));
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preRotateAround(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAround_orthogonal_affine(angle, pivotX, pivotY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotateAround_general(angle, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotateAround(float angle, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return preRotateAround(angle, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAround_orthogonal_affine_self(angle, pivotX, pivotY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotateAround_general(angle, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAround(float angle, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t0);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t0));
        float _buf0 = Math.fma(this.m20, _t9, Math.fma(this.m00, _t1, -(this.m10 * _t0)));
        d.m10 = Math.fma(this.m20, _t10, Math.fma(this.m00, _t0, this.m10 * _t1));
        d.m20 = this.m20;
        float _buf1 = Math.fma(this.m21, _t9, Math.fma(this.m01, _t1, -(this.m11 * _t0)));
        d.m11 = Math.fma(this.m21, _t10, Math.fma(this.m01, _t0, this.m11 * _t1));
        d.m21 = this.m21;
        float _buf2 = Math.fma(this.m22, _t9, Math.fma(this.m02, _t1, -(this.m12 * _t0)));
        d.m12 = Math.fma(this.m22, _t10, Math.fma(this.m02, _t0, this.m12 * _t1));
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 preRotateAxis(float angle, Float3R axis, @Mutated Float3x3 dest) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAxis(float angle, Float3R axis, @Mutated Double3x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preRotateAxis(float angle, Float3R axis) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_identity(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        d.m00 = Math.fma(_t2, axisX * axisX, _t0);
        d.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        d.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        d.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        d.m11 = Math.fma(_t2, axisY * axisY, _t0);
        d.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        d.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        d.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        d.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_translation(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t4 = axisX * axisY;
        float _t6 = axisX * axisZ;
        float _t8 = axisY * axisZ;
        float _t14 = Math.fma(_t2, axisX * axisX, _t0);
        float _t15 = Math.fma(_t2, axisY * axisY, _t0);
        float _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        float _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        float _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        float _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        d.m00 = _t14;
        d.m10 = _t16;
        d.m20 = _t19;
        d.m01 = _t18;
        d.m11 = _t15;
        d.m21 = _t17;
        float _buf0 = Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(this.m02, _t14, this.m12 * _t18);
        float _buf1 = Math.fma(this.m02, _t16, this.m12 * _t15) + Math.fma(_t2, _t8, -(axisX * _t1));
        d.m22 = Math.fma(this.m02, _t19, Math.fma(this.m12, _t17, Math.fma(_t2, axisZ * axisZ, _t0)));
        d.m02 = _buf0;
        d.m12 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t4 = axisX * axisY;
        float _t6 = axisX * axisZ;
        float _t8 = axisY * axisZ;
        float _t14 = Math.fma(_t2, axisX * axisX, _t0);
        float _t15 = Math.fma(_t2, axisY * axisY, _t0);
        float _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        float _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        float _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        float _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        float _buf0 = Math.fma(this.m00, _t14, this.m10 * _t18);
        float _buf1 = Math.fma(this.m00, _t16, this.m10 * _t15);
        d.m20 = Math.fma(this.m00, _t19, this.m10 * _t17);
        float _buf2 = Math.fma(this.m01, _t14, this.m11 * _t18);
        float _buf3 = Math.fma(this.m01, _t16, this.m11 * _t15);
        d.m21 = Math.fma(this.m01, _t19, this.m11 * _t17);
        float _buf4 = Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(this.m02, _t14, this.m12 * _t18);
        float _buf5 = Math.fma(this.m02, _t16, this.m12 * _t15) + Math.fma(_t2, _t8, -(axisX * _t1));
        d.m22 = Math.fma(this.m02, _t19, Math.fma(this.m12, _t17, Math.fma(_t2, axisZ * axisZ, _t0)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_general(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t1);
        float _t19 = Math.fma(_t2, axisY * axisY, _t1);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        float _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        float _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        float _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        float _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        float _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        float _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        float _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24));
        float _buf1 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19));
        d.m20 = Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23));
        float _buf2 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24));
        float _buf3 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19));
        d.m21 = Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23));
        float _buf4 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24));
        float _buf5 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.properties = 0;
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
    public Float3x3 preRotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotateAxis(float angle, float axisX, float axisY, float axisZ) {
        if (Joml.RETURN_NEW) return preRotateAxis(angle, axisX, axisY, axisZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return preRotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3x3 preRotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t1);
        float _t19 = Math.fma(_t2, axisY * axisY, _t1);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        float _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        float _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        float _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        float _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        float _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        float _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        float _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24));
        float _buf1 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19));
        d.m20 = Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23));
        float _buf2 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24));
        float _buf3 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19));
        d.m21 = Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23));
        float _buf4 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24));
        float _buf5 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_identity(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = _t0;
        d.m21 = _t1;
        d.m02 = 0.0f;
        d.m12 = -_t1;
        d.m22 = _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_identity_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m11 = _t0;
        d.m21 = _t1;
        d.m12 = -_t1;
        d.m22 = _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = _t0;
        d.m21 = _t1;
        d.m02 = this.m02;
        float _buf0 = Math.fma(this.m12, _t0, -_t1);
        d.m22 = Math.fma(this.m12, _t1, _t0);
        d.m12 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m11 = _t0;
        d.m21 = _t1;
        d.m02 = this.m02;
        float _buf0 = Math.fma(this.m12, _t0, -_t1);
        d.m22 = Math.fma(this.m12, _t1, _t0);
        d.m12 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_orthogonal(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        float _buf0 = this.m10 * _t0;
        d.m20 = this.m10 * _t1;
        d.m01 = this.m01;
        float _buf1 = this.m11 * _t0;
        d.m21 = this.m11 * _t1;
        d.m02 = this.m02;
        float _buf2 = Math.fma(this.m12, _t0, -_t1);
        d.m22 = Math.fma(this.m12, _t1, _t0);
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m12 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        float _buf0 = Math.fma(this.m10, _t0, -(this.m20 * _t1));
        d.m20 = Math.fma(this.m10, _t1, this.m20 * _t0);
        d.m01 = this.m01;
        float _buf1 = Math.fma(this.m11, _t0, -(this.m21 * _t1));
        d.m21 = Math.fma(this.m11, _t1, this.m21 * _t0);
        d.m02 = this.m02;
        float _buf2 = Math.fma(this.m12, _t0, -(this.m22 * _t1));
        d.m22 = Math.fma(this.m12, _t1, this.m22 * _t0);
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m12 = _buf2;
        d.properties = 0;
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
    public Float3x3 preRotateX(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateX_orthogonal(angle, dest);
        return preRotateX_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotateX(float angle) {
        if (Joml.RETURN_NEW) return preRotateX(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateX_orthogonal(angle, this);
        return preRotateX_general(angle, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateX(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        float _buf0 = Math.fma(this.m10, _t0, -(this.m20 * _t1));
        d.m20 = Math.fma(this.m10, _t1, this.m20 * _t0);
        d.m01 = this.m01;
        float _buf1 = Math.fma(this.m11, _t0, -(this.m21 * _t1));
        d.m21 = Math.fma(this.m11, _t1, this.m21 * _t0);
        d.m02 = this.m02;
        float _buf2 = Math.fma(this.m12, _t0, -(this.m22 * _t1));
        d.m22 = Math.fma(this.m12, _t1, this.m22 * _t0);
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m12 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_identity(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = 0.0f;
        d.m20 = -_t1;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = _t1;
        d.m12 = 0.0f;
        d.m22 = _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_identity_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m20 = -_t1;
        d.m02 = _t1;
        d.m22 = _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = 0.0f;
        d.m20 = -_t1;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        float _buf0 = Math.fma(this.m02, _t0, _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(-this.m02, _t1, _t0);
        d.m02 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m20 = -_t1;
        float _buf0 = Math.fma(this.m02, _t0, _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(-this.m02, _t1, _t0);
        d.m02 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_orthogonal(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m11 * _t0;
        float _buf0 = this.m10;
        d.m20 = -(this.m11 * _t1);
        d.m01 = -(this.m10 * _t0);
        d.m11 = this.m11;
        d.m21 = this.m10 * _t1;
        float _buf1 = Math.fma(this.m02, _t0, _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(-this.m02, _t1, _t0);
        d.m10 = _buf0;
        d.m02 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_affine(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = this.m00 * _t0;
        d.m10 = this.m10;
        d.m20 = -(this.m00 * _t1);
        float _buf1 = this.m01 * _t0;
        d.m11 = this.m11;
        d.m21 = -(this.m01 * _t1);
        float _buf2 = Math.fma(this.m02, _t0, _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(-this.m02, _t1, _t0);
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m20 * _t1);
        d.m10 = this.m10;
        d.m20 = Math.fma(this.m20, _t0, -(this.m00 * _t1));
        float _buf1 = Math.fma(this.m01, _t0, this.m21 * _t1);
        d.m11 = this.m11;
        d.m21 = Math.fma(this.m21, _t0, -(this.m01 * _t1));
        float _buf2 = Math.fma(this.m02, _t0, this.m22 * _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(this.m22, _t0, -(this.m02 * _t1));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
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
    public Float3x3 preRotateY(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateY_affine(angle, dest);
        return preRotateY_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotateY(float angle) {
        if (Joml.RETURN_NEW) return preRotateY(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation_self(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateY_affine(angle, this);
        return preRotateY_general(angle, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateY(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m20 * _t1);
        d.m10 = this.m10;
        d.m20 = Math.fma(this.m20, _t0, -(this.m00 * _t1));
        float _buf1 = Math.fma(this.m01, _t0, this.m21 * _t1);
        d.m11 = this.m11;
        d.m21 = Math.fma(this.m21, _t0, -(this.m01 * _t1));
        float _buf2 = Math.fma(this.m02, _t0, this.m22 * _t1);
        d.m12 = this.m12;
        d.m22 = Math.fma(this.m22, _t0, -(this.m02 * _t1));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
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
    public Float3x3 preRotateZ(float angle, @Mutated Float3x3 dest) {
        return preRotate(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateZ(float angle, @Mutated Double3x3 dest) {
        return preRotate(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preRotateZ(float angle) {
        return preRotate(angle);
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
    public Float3x3 preScale(Float2R v, @Mutated Float3x3 dest) {
        return preScale(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(Float2R v, @Mutated Double3x3 dest) {
        return preScale(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preScale(Float2R v) {
        return preScale(v.x(), v.y());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = vY;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m11 = vY;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = vY;
        d.m21 = 0.0f;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m11 = vY;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vY;
        d.m20 = 0.0f;
        d.m01 = this.m01 * vX;
        d.m11 = this.m11 * vY;
        d.m21 = 0.0f;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vY;
        d.m01 = this.m01 * vX;
        d.m11 = this.m11 * vY;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_general(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vY;
        d.m20 = this.m20;
        d.m01 = this.m01 * vX;
        d.m11 = this.m11 * vY;
        d.m21 = this.m21;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preScale(float vX, float vY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(vX, vY, dest);
        return preScale_general(vX, vY, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preScale(float vX, float vY) {
        if (Joml.RETURN_NEW) return preScale(vX, vY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal_self(vX, vY, this);
        return preScale_general(vX, vY, this);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(float vX, float vY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vY;
        d.m20 = this.m20;
        d.m01 = this.m01 * vX;
        d.m11 = this.m11 * vY;
        d.m21 = this.m21;
        d.m02 = this.m02 * vX;
        d.m12 = this.m12 * vY;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity_self(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation_self(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = 0.0f;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = 0.0f;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal_self(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_general(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = this.m20;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = this.m21;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preScale(float s, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(s, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(s, dest);
        return preScale_general(s, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preScale(float s) {
        if (Joml.RETURN_NEW) return preScale(s, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(s, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal_self(s, this);
        return preScale_general(s, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(float s, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = this.m20;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = this.m21;
        d.m02 = s * this.m02;
        d.m12 = s * this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} onto this matrix and store the result in {@code dest}.
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
    public Float3x3 preScaleAround(float s, Float2R pivot, @Mutated Float3x3 dest) {
        return preScaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(float s, Float2R pivot, @Mutated Double3x3 dest) {
        return preScaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preScaleAround(float s, Float2R pivot) {
        return preScaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-s, pivotX, pivotX);
        d.m12 = Math.fma(-s, pivotY, pivotY);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m02 = Math.fma(-s, pivotX, pivotX);
        d.m12 = Math.fma(-s, pivotY, pivotY);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX));
        d.m12 = Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m02 = Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX));
        d.m12 = Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = 0.0f;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX));
        d.m12 = Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m02 = Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX));
        d.m12 = Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_general(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        d.m00 = Math.fma(s, this.m00, this.m20 * _t0);
        d.m10 = Math.fma(s, this.m10, this.m20 * _t1);
        d.m20 = this.m20;
        d.m01 = Math.fma(s, this.m01, this.m21 * _t0);
        d.m11 = Math.fma(s, this.m11, this.m21 * _t1);
        d.m21 = this.m21;
        d.m02 = Math.fma(s, this.m02, this.m22 * _t0);
        d.m12 = Math.fma(s, this.m12, this.m22 * _t1);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preScaleAround(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(s, pivotX, pivotY, dest);
        return preScaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preScaleAround(float s, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(s, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal_self(s, pivotX, pivotY, this);
        return preScaleAround_general(s, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(float s, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        d.m00 = Math.fma(s, this.m00, this.m20 * _t0);
        d.m10 = Math.fma(s, this.m10, this.m20 * _t1);
        d.m20 = this.m20;
        d.m01 = Math.fma(s, this.m01, this.m21 * _t0);
        d.m11 = Math.fma(s, this.m11, this.m21 * _t1);
        d.m21 = this.m21;
        d.m02 = Math.fma(s, this.m02, this.m22 * _t0);
        d.m12 = Math.fma(s, this.m12, this.m22 * _t1);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
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
    public Float3x3 preScaleAround(Float2R s, Float2R pivot, @Mutated Float3x3 dest) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(Float2R s, Float2R pivot, @Mutated Double3x3 dest) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preScaleAround(Float2R s, Float2R pivot) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = sY;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-pivotX, sX, pivotX);
        d.m12 = Math.fma(-pivotY, sY, pivotY);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m11 = sY;
        d.m02 = Math.fma(-pivotX, sX, pivotX);
        d.m12 = Math.fma(-pivotY, sY, pivotY);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = sY;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX));
        d.m12 = Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m11 = sY;
        d.m02 = Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX));
        d.m12 = Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX * this.m00;
        d.m10 = sY * this.m10;
        d.m20 = 0.0f;
        d.m01 = sX * this.m01;
        d.m11 = sY * this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX));
        d.m12 = Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX * this.m00;
        d.m10 = sY * this.m10;
        d.m01 = sX * this.m01;
        d.m11 = sY * this.m11;
        d.m02 = Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX));
        d.m12 = Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_general(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        d.m00 = Math.fma(sX, this.m00, this.m20 * _t2);
        d.m10 = Math.fma(sY, this.m10, this.m20 * _t3);
        d.m20 = this.m20;
        d.m01 = Math.fma(sX, this.m01, this.m21 * _t2);
        d.m11 = Math.fma(sY, this.m11, this.m21 * _t3);
        d.m21 = this.m21;
        d.m02 = Math.fma(sX, this.m02, this.m22 * _t2);
        d.m12 = Math.fma(sY, this.m12, this.m22 * _t3);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preScaleAround(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
        return preScaleAround_general(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preScaleAround(float sX, float sY, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(sX, sY, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal_self(sX, sY, pivotX, pivotY, this);
        return preScaleAround_general(sX, sY, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(float sX, float sY, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        d.m00 = Math.fma(sX, this.m00, this.m20 * _t2);
        d.m10 = Math.fma(sY, this.m10, this.m20 * _t3);
        d.m20 = this.m20;
        d.m01 = Math.fma(sX, this.m01, this.m21 * _t2);
        d.m11 = Math.fma(sY, this.m11, this.m21 * _t3);
        d.m21 = this.m21;
        d.m02 = Math.fma(sX, this.m02, this.m22 * _t2);
        d.m12 = Math.fma(sY, this.m12, this.m22 * _t3);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
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
    public Float3x3 preTranslate(Float2R v, @Mutated Float3x3 dest) {
        return preTranslate(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preTranslate(Float2R v, @Mutated Double3x3 dest) {
        return preTranslate(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 preTranslate(Float2R v) {
        return preTranslate(v.x(), v.y());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_orthogonal_affine(float vX, float vY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = this.m02 + vX;
        d.m12 = this.m12 + vY;
        d.m22 = 1.0f;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_orthogonal_affine_self(float vX, float vY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = this.m02 + vX;
        d.m12 = this.m12 + vY;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_identity(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = vX;
        d.m12 = vY;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_identity_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m02 = vX;
        d.m12 = vY;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_translation(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02 + vX;
        d.m12 = this.m12 + vY;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_translation_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m02 = this.m02 + vX;
        d.m12 = this.m12 + vY;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_general(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = Math.fma(this.m20, vX, this.m00);
        d.m10 = Math.fma(this.m20, vY, this.m10);
        d.m20 = this.m20;
        d.m01 = Math.fma(this.m21, vX, this.m01);
        d.m11 = Math.fma(this.m21, vY, this.m11);
        d.m21 = this.m21;
        d.m02 = Math.fma(this.m22, vX, this.m02);
        d.m12 = Math.fma(this.m22, vY, this.m12);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 preTranslate(float vX, float vY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preTranslate_orthogonal_affine(vX, vY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preTranslate_general(vX, vY, dest);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 preTranslate(float vX, float vY) {
        if (Joml.RETURN_NEW) return preTranslate(vX, vY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preTranslate_orthogonal_affine_self(vX, vY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preTranslate_general(vX, vY, this);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preTranslate(float vX, float vY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = Math.fma(this.m20, vX, this.m00);
        d.m10 = Math.fma(this.m20, vY, this.m10);
        d.m20 = this.m20;
        d.m01 = Math.fma(this.m21, vX, this.m01);
        d.m11 = Math.fma(this.m21, vY, this.m11);
        d.m21 = this.m21;
        d.m02 = Math.fma(this.m22, vX, this.m02);
        d.m12 = Math.fma(this.m22, vY, this.m12);
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_orthogonal_affine(float angle, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        d.m20 = 0.0f;
        d.m01 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        d.m11 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_orthogonal_affine_self(float angle, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        d.m01 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        d.m11 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_identity(float angle, @Mutated Float3x3 dest) {
        return preRotate_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_identity_self(float angle, @Mutated Float3x3 dest) {
        return preRotate_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        float _buf2 = Math.fma(this.m20, _t0, this.m21 * _t1);
        d.m01 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        d.m11 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m21 = Math.fma(this.m21, _t0, -(this.m20 * _t1));
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a rotation by {@code angle} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 rotate(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_orthogonal_affine(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotate_general(angle, dest);
    }


    /**
     * Apply a rotation by {@code angle} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotate(float angle) {
        if (Joml.RETURN_NEW) return rotate(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_orthogonal_affine_self(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotate_general(angle, this);
    }


    /**
     * Apply a rotation by {@code angle} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotate(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        float _buf2 = Math.fma(this.m20, _t0, this.m21 * _t1);
        d.m01 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        d.m11 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m21 = Math.fma(this.m21, _t0, -(this.m20 * _t1));
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 rotateAround(float angle, Float2R pivot, @Mutated Float3x3 dest) {
        return rotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAround(float angle, Float2R pivot, @Mutated Double3x3 dest) {
        return rotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 rotateAround(float angle, Float2R pivot) {
        return rotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_orthogonal_affine(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        d.m20 = 0.0f;
        float _buf2 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        float _buf3 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m00, _t9, Math.fma(this.m01, _t10, this.m02));
        d.m12 = Math.fma(this.m10, _t9, Math.fma(this.m11, _t10, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_orthogonal_affine_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        float _buf2 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        float _buf3 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m02 = Math.fma(this.m00, _t9, Math.fma(this.m01, _t10, this.m02));
        d.m12 = Math.fma(this.m10, _t9, Math.fma(this.m11, _t10, this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_identity(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preRotateAround_identity(angle, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_identity_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preRotateAround_identity_self(angle, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_translation(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m20 = 0.0f;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = Math.fma(pivotX, _t5, Math.fma(pivotY, _t1, this.m02));
        d.m12 = Math.fma(pivotY, _t5, Math.fma(-pivotX, _t1, this.m12));
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_translation_self(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t5 = 2.0f * _t3 * _t3;
        d.m00 = _t0;
        d.m10 = _t1;
        d.m01 = -_t1;
        d.m11 = _t0;
        d.m02 = Math.fma(pivotX, _t5, Math.fma(pivotY, _t1, this.m02));
        d.m12 = Math.fma(pivotY, _t5, Math.fma(-pivotX, _t1, this.m12));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_general(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        float _buf2 = Math.fma(this.m20, _t0, this.m21 * _t1);
        float _buf3 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        float _buf4 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        float _buf5 = Math.fma(this.m21, _t0, -(this.m20 * _t1));
        d.m02 = Math.fma(this.m00, _t9, Math.fma(this.m01, _t10, this.m02));
        d.m12 = Math.fma(this.m10, _t9, Math.fma(this.m11, _t10, this.m12));
        d.m22 = Math.fma(this.m20, _t9, Math.fma(this.m21, _t10, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 rotateAround(float angle, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAround_orthogonal_affine(angle, pivotX, pivotY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateAround_general(angle, pivotX, pivotY, dest);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateAround(float angle, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return rotateAround(angle, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAround_orthogonal_affine_self(angle, pivotX, pivotY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateAround_general(angle, pivotX, pivotY, this);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAround(float angle, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        float _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        float _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        float _buf2 = Math.fma(this.m20, _t0, this.m21 * _t1);
        float _buf3 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        float _buf4 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        float _buf5 = Math.fma(this.m21, _t0, -(this.m20 * _t1));
        d.m02 = Math.fma(this.m00, _t9, Math.fma(this.m01, _t10, this.m02));
        d.m12 = Math.fma(this.m10, _t9, Math.fma(this.m11, _t10, this.m12));
        d.m22 = Math.fma(this.m20, _t9, Math.fma(this.m21, _t10, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateAxis(float angle, Float3R axis, @Mutated Float3x3 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAxis(float angle, Float3R axis, @Mutated Double3x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 rotateAxis(float angle, Float3R axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_identity(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_translation(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        float _t6 = axisX * axisY;
        float _t10 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t11 = Math.fma(axisX, _t1, _t2 * _t5);
        float _t12 = Math.fma(_t2, _t3, -(axisY * _t1));
        d.m00 = Math.fma(_t2, axisX * axisX, Math.fma(this.m02, _t12, _t0));
        d.m10 = Math.fma(this.m12, _t12, Math.fma(axisZ, _t1, _t2 * _t6));
        d.m20 = _t12;
        d.m01 = Math.fma(this.m02, _t11, Math.fma(_t2, _t6, -(axisZ * _t1)));
        d.m11 = Math.fma(_t2, axisY * axisY, Math.fma(this.m12, _t11, _t0));
        d.m21 = _t11;
        d.m02 = Math.fma(this.m02, _t10, Math.fma(axisY, _t1, _t2 * _t3));
        d.m12 = Math.fma(this.m12, _t10, Math.fma(_t2, _t5, -(axisX * _t1)));
        d.m22 = _t10;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        float _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21));
        float _buf1 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21));
        d.m20 = _t24;
        float _buf2 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19));
        float _buf3 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19));
        d.m21 = _t22;
        d.m02 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m12 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m22 = _t20;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_general(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        float _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21));
        float _buf1 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21));
        float _buf2 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21));
        float _buf3 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19));
        float _buf4 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19));
        float _buf5 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19));
        d.m02 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m12 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        if (Joml.RETURN_NEW) return rotateAxis(angle, axisX, axisY, axisZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return rotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3x3 rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        float _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21));
        float _buf1 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21));
        float _buf2 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21));
        float _buf3 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19));
        float _buf4 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19));
        float _buf5 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19));
        d.m02 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m12 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_identity(float angle, @Mutated Float3x3 dest) {
        return preRotateX_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_identity_self(float angle, @Mutated Float3x3 dest) {
        return preRotateX_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = this.m02 * _t0;
        d.m11 = Math.fma(this.m12, _t0, _t1);
        d.m21 = _t0;
        d.m02 = this.m02 * _t1;
        d.m12 = Math.fma(this.m12, _t1, -_t0);
        d.m22 = _t1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m01 = this.m02 * _t0;
        d.m11 = Math.fma(this.m12, _t0, _t1);
        d.m21 = _t0;
        d.m02 = this.m02 * _t1;
        d.m12 = Math.fma(this.m12, _t1, -_t0);
        d.m22 = _t1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_orthogonal(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m20 = 0.0f;
        d.m01 = Math.fma(this.m02, _t0, -(this.m10 * _t1));
        float _buf1 = Math.fma(this.m11, _t1, this.m12 * _t0);
        d.m21 = _t0;
        d.m02 = Math.fma(this.m02, _t1, this.m10 * _t0);
        d.m12 = Math.fma(this.m12, _t1, -(this.m11 * _t0));
        d.m22 = _t1;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_orthogonal_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m01 = Math.fma(this.m02, _t0, -(this.m10 * _t1));
        float _buf1 = Math.fma(this.m11, _t1, this.m12 * _t0);
        d.m21 = _t0;
        d.m02 = Math.fma(this.m02, _t1, this.m10 * _t0);
        d.m12 = Math.fma(this.m12, _t1, -(this.m11 * _t0));
        d.m22 = _t1;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_affine(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        float _buf0 = Math.fma(this.m01, _t0, this.m02 * _t1);
        float _buf1 = Math.fma(this.m11, _t0, this.m12 * _t1);
        d.m21 = _t1;
        d.m02 = Math.fma(this.m02, _t0, -(this.m01 * _t1));
        d.m12 = Math.fma(this.m12, _t0, -(this.m11 * _t1));
        d.m22 = _t0;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_affine_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        d.m10 = this.m10;
        float _buf0 = Math.fma(this.m01, _t0, this.m02 * _t1);
        float _buf1 = Math.fma(this.m11, _t0, this.m12 * _t1);
        d.m21 = _t1;
        d.m02 = Math.fma(this.m02, _t0, -(this.m01 * _t1));
        d.m12 = Math.fma(this.m12, _t0, -(this.m11 * _t1));
        d.m22 = _t0;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = Math.fma(this.m01, _t0, this.m02 * _t1);
        float _buf1 = Math.fma(this.m11, _t0, this.m12 * _t1);
        float _buf2 = Math.fma(this.m21, _t0, this.m22 * _t1);
        d.m02 = Math.fma(this.m02, _t0, -(this.m01 * _t1));
        d.m12 = Math.fma(this.m12, _t0, -(this.m11 * _t1));
        d.m22 = Math.fma(this.m22, _t0, -(this.m21 * _t1));
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
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
    public Float3x3 rotateX(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX_affine(angle, dest);
        return rotateX_general(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateX(float angle) {
        if (Joml.RETURN_NEW) return rotateX(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation_self(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX_affine_self(angle, this);
        return rotateX_general(angle, this);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = Math.fma(this.m01, _t0, this.m02 * _t1);
        float _buf1 = Math.fma(this.m11, _t0, this.m12 * _t1);
        float _buf2 = Math.fma(this.m21, _t0, this.m22 * _t1);
        d.m02 = Math.fma(this.m02, _t0, -(this.m01 * _t1));
        d.m12 = Math.fma(this.m12, _t0, -(this.m11 * _t1));
        d.m22 = Math.fma(this.m22, _t0, -(this.m21 * _t1));
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m11 = -1.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m11 = -1.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        d.m11 = -this.m11;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m01 = this.m10;
        d.m11 = -this.m11;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.m10 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateX180(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX180_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX180_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX180_affine(dest);
        return rotateX180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateX180() {
        if (Joml.RETURN_NEW) return rotateX180(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX180_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX180_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX180_affine_self(this);
        return rotateX180_general(this);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX180(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = -1.0f;
        d.m02 = 0.0f;
        d.m12 = 1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m11 = 0.0f;
        d.m21 = -1.0f;
        d.m12 = 1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = -this.m02;
        d.m11 = -this.m12;
        d.m21 = -1.0f;
        d.m02 = 0.0f;
        d.m12 = 1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m01 = -this.m02;
        d.m11 = -this.m12;
        d.m21 = -1.0f;
        d.m02 = 0.0f;
        d.m12 = 1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        d.m21 = -1.0f;
        d.m02 = this.m01;
        d.m12 = this.m11;
        d.m22 = 0.0f;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        d.m21 = -1.0f;
        d.m02 = this.m01;
        d.m12 = this.m11;
        d.m22 = 0.0f;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        float _buf2 = -this.m22;
        d.m02 = this.m01;
        d.m12 = this.m11;
        d.m22 = this.m21;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateX270(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX270_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX270_orthogonal(dest);
        return rotateX270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateX270() {
        if (Joml.RETURN_NEW) return rotateX270(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX270_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX270_orthogonal_self(this);
        return rotateX270_general(this);
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX270(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        float _buf2 = -this.m22;
        d.m02 = this.m01;
        d.m12 = this.m11;
        d.m22 = this.m21;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 0.0f;
        d.m21 = 1.0f;
        d.m02 = 0.0f;
        d.m12 = -1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m11 = 0.0f;
        d.m21 = 1.0f;
        d.m12 = -1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = this.m02;
        d.m11 = this.m12;
        d.m21 = 1.0f;
        d.m02 = 0.0f;
        d.m12 = -1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m01 = this.m02;
        d.m11 = this.m12;
        d.m21 = 1.0f;
        d.m02 = 0.0f;
        d.m12 = -1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m02;
        float _buf1 = this.m12;
        d.m21 = 1.0f;
        d.m02 = this.m10;
        d.m12 = -this.m11;
        d.m22 = 0.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m11;
        float _buf0 = this.m10;
        d.m01 = this.m02;
        float _buf1 = this.m12;
        d.m21 = 1.0f;
        d.m02 = this.m10;
        d.m12 = -this.m11;
        d.m22 = 0.0f;
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = 0.0f;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        d.m21 = 1.0f;
        d.m02 = -this.m01;
        d.m12 = -this.m11;
        d.m22 = 0.0f;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        d.m21 = 1.0f;
        d.m02 = -this.m01;
        d.m12 = -this.m11;
        d.m22 = 0.0f;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        float _buf2 = this.m22;
        d.m02 = -this.m01;
        d.m12 = -this.m11;
        d.m22 = -this.m21;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateX90(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX90_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX90_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX90_affine(dest);
        return rotateX90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateX90() {
        if (Joml.RETURN_NEW) return rotateX90(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX90_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX90_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX90_affine_self(this);
        return rotateX90_general(this);
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX90(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        float _buf2 = this.m22;
        d.m02 = -this.m01;
        d.m12 = -this.m11;
        d.m22 = -this.m21;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        d.m00 = _t0 * _t1;
        d.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        d.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        d.m01 = -(_t2 * _t0);
        d.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        d.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        d.m02 = _t3;
        d.m12 = -(_t4 * _t0);
        d.m22 = _t5 * _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t8 = _t3 * _t5;
        float _t9 = _t0 * _t2;
        float _t12 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t13 = Math.fma(_t0, _t1, -(_t6 * _t4));
        d.m00 = Math.fma(this.m02, _t13, _t5 * _t4);
        d.m10 = Math.fma(this.m12, _t13, Math.fma(_t9, _t4, _t1 * _t3));
        d.m20 = _t13;
        d.m01 = Math.fma(this.m02, _t12, -(_t1 * _t5));
        d.m11 = Math.fma(this.m12, _t12, Math.fma(_t3, _t4, -(_t9 * _t1)));
        d.m21 = _t12;
        d.m02 = Math.fma(this.m02, _t8, _t2);
        d.m12 = Math.fma(this.m12, _t8, -(_t0 * _t5));
        d.m22 = _t8;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18));
        d.m20 = _t20;
        float _buf2 = Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11)));
        float _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11)));
        d.m21 = _t19;
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13)));
        d.m22 = _t12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t7, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11)));
        float _buf4 = Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11)));
        float _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m21, _t21, -(this.m20 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13)));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t2, -(this.m21 * _t13)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateXYZ(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXYZ_orthogonal(angleX, angleY, angleZ, dest);
        return rotateXYZ_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateXYZ(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateXYZ(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXYZ_orthogonal(angleX, angleY, angleZ, this);
        return rotateXYZ_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXYZ(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t7, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11)));
        float _buf4 = Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11)));
        float _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m21, _t21, -(this.m20 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13)));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t2, -(this.m21 * _t13)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        d.m00 = _t0 * _t1;
        d.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        d.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        d.m01 = -_t2;
        d.m11 = _t4 * _t1;
        d.m21 = _t5 * _t1;
        d.m02 = _t3 * _t1;
        d.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        d.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t5;
        float _t10 = _t1 * _t4;
        float _t12 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        d.m00 = Math.fma(this.m02, _t13, _t2 * _t5);
        d.m10 = Math.fma(this.m12, _t13, Math.fma(_t10, _t2, _t0 * _t3));
        d.m20 = _t13;
        d.m01 = Math.fma(this.m02, _t8, -_t1);
        d.m11 = Math.fma(this.m12, _t8, _t4 * _t5);
        d.m21 = _t8;
        d.m02 = Math.fma(this.m02, _t12, _t3 * _t5);
        d.m12 = Math.fma(this.m12, _t12, Math.fma(_t10, _t3, -(_t0 * _t2)));
        d.m22 = _t12;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18));
        d.m20 = _t20;
        float _buf2 = Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1)));
        float _buf3 = Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1)));
        d.m21 = _t11;
        d.m02 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21));
        d.m22 = _t19;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t8, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1)));
        float _buf4 = Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1)));
        float _buf5 = Math.fma(this.m22, _t11, Math.fma(this.m21, _t12, -(this.m20 * _t1)));
        d.m02 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t14, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateXZY(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXZY_orthogonal(angleX, angleY, angleZ, dest);
        return rotateXZY_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateXZY(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateXZY(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXZY_orthogonal(angleX, angleY, angleZ, this);
        return rotateXZY_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXZY(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t8, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1)));
        float _buf4 = Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1)));
        float _buf5 = Math.fma(this.m22, _t11, Math.fma(this.m21, _t12, -(this.m20 * _t1)));
        d.m02 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t14, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateXn180(@Mutated Float3x3 dest) {
        return rotateX180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn180(@Mutated Double3x3 dest) {
        return rotateX180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateXn180() {
        return rotateX180();
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
    public Float3x3 rotateXn270(@Mutated Float3x3 dest) {
        return rotateX90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn270(@Mutated Double3x3 dest) {
        return rotateX90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateXn270() {
        return rotateX90();
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
    public Float3x3 rotateXn90(@Mutated Float3x3 dest) {
        return rotateX270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn90(@Mutated Double3x3 dest) {
        return rotateX270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateXn90() {
        return rotateX270();
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_identity(float angle, @Mutated Float3x3 dest) {
        return preRotateY_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_identity_self(float angle, @Mutated Float3x3 dest) {
        return preRotateY_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_translation(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m00 = Math.fma(-this.m02, _t0, _t1);
        d.m10 = -(this.m12 * _t0);
        d.m20 = -_t0;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m02, _t1, _t0);
        d.m12 = this.m12 * _t1;
        d.m22 = _t1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_translation_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        d.m00 = Math.fma(-this.m02, _t0, _t1);
        d.m10 = -(this.m12 * _t0);
        d.m20 = -_t0;
        d.m02 = Math.fma(this.m02, _t1, _t0);
        d.m12 = this.m12 * _t1;
        d.m22 = _t1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_orthogonal(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m02 * _t1));
        float _buf1 = Math.fma(this.m10, _t0, -(this.m12 * _t1));
        d.m20 = -_t1;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m00, _t1, this.m02 * _t0);
        d.m12 = Math.fma(this.m10, _t1, this.m12 * _t0);
        d.m22 = _t0;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_orthogonal_self(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m02 * _t1));
        float _buf1 = Math.fma(this.m10, _t0, -(this.m12 * _t1));
        d.m20 = -_t1;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = Math.fma(this.m00, _t1, this.m02 * _t0);
        d.m12 = Math.fma(this.m10, _t1, this.m12 * _t0);
        d.m22 = _t0;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_general(float angle, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m02 * _t1));
        float _buf1 = Math.fma(this.m10, _t0, -(this.m12 * _t1));
        float _buf2 = Math.fma(this.m20, _t0, -(this.m22 * _t1));
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = Math.fma(this.m00, _t1, this.m02 * _t0);
        d.m12 = Math.fma(this.m10, _t1, this.m12 * _t0);
        d.m22 = Math.fma(this.m20, _t1, this.m22 * _t0);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
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
    public Float3x3 rotateY(float angle, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY_orthogonal(angle, dest);
        return rotateY_general(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateY(float angle) {
        if (Joml.RETURN_NEW) return rotateY(angle, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY_orthogonal_self(angle, this);
        return rotateY_general(angle, this);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY(float angle, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(this.m00, _t0, -(this.m02 * _t1));
        float _buf1 = Math.fma(this.m10, _t0, -(this.m12 * _t1));
        float _buf2 = Math.fma(this.m20, _t0, -(this.m22 * _t1));
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = Math.fma(this.m00, _t1, this.m02 * _t0);
        d.m12 = Math.fma(this.m10, _t1, this.m12 * _t0);
        d.m22 = Math.fma(this.m20, _t1, this.m22 * _t0);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -1.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateY180(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY180_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY180_orthogonal(dest);
        return rotateY180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateY180() {
        if (Joml.RETURN_NEW) return rotateY180(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY180_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY180_orthogonal_self(this);
        return rotateY180_general(this);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY180(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = 1.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m20 = 1.0f;
        d.m02 = -1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m02;
        d.m10 = this.m12;
        d.m20 = 1.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = -1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m02;
        d.m10 = this.m12;
        d.m20 = 1.0f;
        d.m02 = -1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        d.m20 = 1.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = -this.m00;
        d.m12 = -this.m10;
        d.m22 = 0.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        d.m20 = 1.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = -this.m00;
        d.m12 = -this.m10;
        d.m22 = 0.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        float _buf2 = this.m22;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = -this.m00;
        d.m12 = -this.m10;
        d.m22 = -this.m20;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateY270(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY270_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY270_orthogonal(dest);
        return rotateY270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateY270() {
        if (Joml.RETURN_NEW) return rotateY270(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY270_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY270_orthogonal_self(this);
        return rotateY270_general(this);
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY270(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = this.m02;
        float _buf1 = this.m12;
        float _buf2 = this.m22;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = -this.m00;
        d.m12 = -this.m10;
        d.m22 = -this.m20;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 0.0f;
        d.m20 = -1.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m20 = -1.0f;
        d.m02 = 1.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m02;
        d.m10 = -this.m12;
        d.m20 = -1.0f;
        d.m01 = 0.0f;
        d.m11 = 1.0f;
        d.m21 = 0.0f;
        d.m02 = 1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m02;
        d.m10 = -this.m12;
        d.m20 = -1.0f;
        d.m02 = 1.0f;
        d.m12 = 0.0f;
        d.m22 = 0.0f;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        d.m20 = -1.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = 0.0f;
        d.m02 = this.m00;
        d.m12 = this.m10;
        d.m22 = 0.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        d.m20 = -1.0f;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m02 = this.m00;
        d.m12 = this.m10;
        d.m22 = 0.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        float _buf2 = -this.m22;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = this.m00;
        d.m12 = this.m10;
        d.m22 = this.m20;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateY90(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY90_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY90_orthogonal(dest);
        return rotateY90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateY90() {
        if (Joml.RETURN_NEW) return rotateY90(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY90_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY90_orthogonal_self(this);
        return rotateY90_general(this);
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY90(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = -this.m02;
        float _buf1 = -this.m12;
        float _buf2 = -this.m22;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = this.m00;
        d.m12 = this.m10;
        d.m22 = this.m20;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        d.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        d.m10 = _t2 * _t5;
        d.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        d.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        d.m11 = _t5 * _t4;
        d.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        d.m02 = _t1 * _t5;
        d.m12 = -_t0;
        d.m22 = _t5 * _t3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t5 * _t1;
        float _t12 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        d.m00 = Math.fma(this.m02, _t13, Math.fma(_t8, _t2, _t1 * _t4));
        d.m10 = Math.fma(this.m12, _t13, _t2 * _t5);
        d.m20 = _t13;
        d.m01 = Math.fma(this.m02, _t12, Math.fma(_t8, _t4, -(_t2 * _t1)));
        d.m11 = Math.fma(this.m12, _t12, _t5 * _t4);
        d.m21 = _t12;
        d.m02 = Math.fma(this.m02, _t10, _t3 * _t5);
        d.m12 = Math.fma(this.m12, _t10, -_t0);
        d.m22 = _t10;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10));
        d.m20 = _t20;
        float _buf2 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13));
        float _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13));
        d.m21 = _t19;
        d.m02 = Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0)));
        d.m12 = Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0)));
        d.m22 = _t14;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t18, this.m21 * _t10));
        float _buf3 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13));
        float _buf4 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13));
        float _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t21, this.m21 * _t13));
        d.m02 = Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0)));
        d.m12 = Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0)));
        d.m22 = Math.fma(this.m22, _t14, Math.fma(this.m20, _t15, -(this.m21 * _t0)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateYXZ(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYXZ_orthogonal(angleX, angleY, angleZ, dest);
        return rotateYXZ_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateYXZ(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateYXZ(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYXZ_orthogonal(angleX, angleY, angleZ, this);
        return rotateYXZ_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYXZ(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        float _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10));
        float _buf1 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10));
        float _buf2 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t18, this.m21 * _t10));
        float _buf3 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13));
        float _buf4 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13));
        float _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t21, this.m21 * _t13));
        d.m02 = Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0)));
        d.m12 = Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0)));
        d.m22 = Math.fma(this.m22, _t14, Math.fma(this.m20, _t15, -(this.m21 * _t0)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        d.m00 = _t0 * _t1;
        d.m10 = _t4;
        d.m20 = -(_t3 * _t1);
        d.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        d.m11 = _t5 * _t1;
        d.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        d.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        d.m12 = -(_t2 * _t1);
        d.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t3;
        float _t9 = _t3 * _t0;
        float _t12 = Math.fma(_t7, _t4, _t5 * _t0);
        float _t13 = Math.fma(_t4, _t0, -(_t7 * _t5));
        d.m00 = Math.fma(_t0, _t1, -(this.m02 * _t6));
        d.m10 = Math.fma(-this.m12, _t6, _t3);
        d.m20 = -_t6;
        d.m01 = Math.fma(this.m02, _t12, Math.fma(_t5, _t2, -(_t9 * _t4)));
        d.m11 = Math.fma(this.m12, _t12, _t4 * _t1);
        d.m21 = _t12;
        d.m02 = Math.fma(this.m02, _t13, Math.fma(_t9, _t5, _t2 * _t4));
        d.m12 = Math.fma(this.m12, _t13, -(_t5 * _t1));
        d.m22 = _t13;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3));
        d.m20 = -_t6;
        float _buf2 = Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11));
        float _buf3 = Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11));
        d.m21 = _t18;
        d.m02 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13)));
        d.m22 = _t21;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3));
        float _buf2 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t7, this.m21 * _t3));
        float _buf3 = Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11));
        float _buf4 = Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11));
        float _buf5 = Math.fma(this.m22, _t18, Math.fma(this.m20, _t20, this.m21 * _t11));
        d.m02 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13)));
        d.m22 = Math.fma(this.m22, _t21, Math.fma(this.m20, _t19, -(this.m21 * _t13)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateYZX(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYZX_orthogonal(angleX, angleY, angleZ, dest);
        return rotateYZX_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateYZX(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateYZX(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYZX_orthogonal(angleX, angleY, angleZ, this);
        return rotateYZX_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYZX(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3));
        float _buf2 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t7, this.m21 * _t3));
        float _buf3 = Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11));
        float _buf4 = Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11));
        float _buf5 = Math.fma(this.m22, _t18, Math.fma(this.m20, _t20, this.m21 * _t11));
        d.m02 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13)));
        d.m12 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13)));
        d.m22 = Math.fma(this.m22, _t21, Math.fma(this.m20, _t19, -(this.m21 * _t13)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateYn180(@Mutated Float3x3 dest) {
        return rotateY180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn180(@Mutated Double3x3 dest) {
        return rotateY180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateYn180() {
        return rotateY180();
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
    public Float3x3 rotateYn270(@Mutated Float3x3 dest) {
        return rotateY90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn270(@Mutated Double3x3 dest) {
        return rotateY90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateYn270() {
        return rotateY90();
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
    public Float3x3 rotateYn90(@Mutated Float3x3 dest) {
        return rotateY270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn90(@Mutated Double3x3 dest) {
        return rotateY270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateYn90() {
        return rotateY270();
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
    public Float3x3 rotateZ(float angle, @Mutated Float3x3 dest) {
        return rotate(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ(float angle, @Mutated Double3x3 dest) {
        return rotate(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZ(float angle) {
        return rotate(angle);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m11 = -1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = -1.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -1.0f;
        d.m11 = -1.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = -this.m11;
        d.m00 = _t0;
        float _buf0 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = this.m10;
        d.m11 = _t0;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = -this.m11;
        d.m00 = _t0;
        float _buf0 = -this.m10;
        d.m01 = this.m10;
        d.m11 = _t0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m10 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = 0.0f;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateZ180(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ180_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ180_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ180_affine(dest);
        return rotateZ180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZ180() {
        if (Joml.RETURN_NEW) return rotateZ180(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ180_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ180_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ180_affine_self(this);
        return rotateZ180_general(this);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ180(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = -1.0f;
        d.m20 = 0.0f;
        d.m01 = 1.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = -1.0f;
        d.m01 = 1.0f;
        d.m11 = 0.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = -1.0f;
        d.m20 = 0.0f;
        d.m01 = 1.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = -1.0f;
        d.m01 = 1.0f;
        d.m11 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_orthogonal(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m10;
        float _buf0 = -this.m11;
        d.m20 = 0.0f;
        d.m01 = this.m11;
        d.m11 = this.m10;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m10 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_orthogonal_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m10;
        float _buf0 = -this.m11;
        d.m01 = this.m11;
        d.m11 = this.m10;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m10 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_affine(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m01;
        float _buf1 = -this.m11;
        d.m20 = 0.0f;
        d.m01 = this.m00;
        d.m11 = this.m10;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_affine_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m01;
        float _buf1 = -this.m11;
        d.m01 = this.m00;
        d.m11 = this.m10;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = -this.m01;
        float _buf1 = -this.m11;
        float _buf2 = -this.m21;
        d.m01 = this.m00;
        d.m11 = this.m10;
        d.m21 = this.m20;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateZ270(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ270_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ270_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ270_affine(dest);
        return rotateZ270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZ270() {
        if (Joml.RETURN_NEW) return rotateZ270(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ270_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ270_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ270_affine_self(this);
        return rotateZ270_general(this);
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ270(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = -this.m01;
        float _buf1 = -this.m11;
        float _buf2 = -this.m21;
        d.m01 = this.m00;
        d.m11 = this.m10;
        d.m21 = this.m20;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_orthogonal_affine(@Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m01;
        float _buf1 = this.m11;
        d.m20 = 0.0f;
        d.m01 = -this.m00;
        d.m11 = -this.m10;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_orthogonal_affine_self(@Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m01;
        float _buf1 = this.m11;
        d.m01 = -this.m00;
        d.m11 = -this.m10;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_identity(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 1.0f;
        d.m20 = 0.0f;
        d.m01 = -1.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = 0.0f;
        d.m12 = 0.0f;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_identity_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 1.0f;
        d.m01 = -1.0f;
        d.m11 = 0.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_translation(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 1.0f;
        d.m20 = 0.0f;
        d.m01 = -1.0f;
        d.m11 = 0.0f;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_translation_self(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = 0.0f;
        d.m10 = 1.0f;
        d.m01 = -1.0f;
        d.m11 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_general(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m01;
        float _buf1 = this.m11;
        float _buf2 = this.m21;
        d.m01 = -this.m00;
        d.m11 = -this.m10;
        d.m21 = -this.m20;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateZ90(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ90_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ90_orthogonal_affine(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateZ90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZ90() {
        if (Joml.RETURN_NEW) return rotateZ90(Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ90_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ90_orthogonal_affine_self(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateZ90_general(this);
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ90(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = this.m01;
        float _buf1 = this.m11;
        float _buf2 = this.m21;
        d.m01 = -this.m00;
        d.m11 = -this.m10;
        d.m21 = -this.m20;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        d.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        d.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        d.m20 = -(_t4 * _t5);
        d.m01 = -(_t3 * _t5);
        d.m11 = _t5 * _t1;
        d.m21 = _t2;
        d.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        d.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        d.m22 = _t5 * _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t1 * _t2;
        float _t9 = _t4 * _t3;
        d.m00 = Math.fma(-this.m02, _t6, Math.fma(_t2, _t3, -(_t7 * _t0)));
        d.m10 = Math.fma(-this.m12, _t6, Math.fma(_t9, _t0, _t5 * _t2));
        d.m20 = -_t6;
        d.m01 = Math.fma(this.m02, _t4, -(_t5 * _t1));
        d.m11 = Math.fma(this.m12, _t4, _t1 * _t3);
        d.m21 = _t4;
        d.m02 = Math.fma(this.m02, _t8, Math.fma(_t7, _t2, _t0 * _t3));
        d.m12 = Math.fma(this.m12, _t8, Math.fma(_t0, _t5, -(_t9 * _t2)));
        d.m22 = _t8;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18));
        d.m20 = -_t6;
        float _buf2 = Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11)));
        float _buf3 = Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11)));
        d.m21 = _t4;
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = _t12;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18));
        float _buf2 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t20, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11)));
        float _buf4 = Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11)));
        float _buf5 = Math.fma(this.m22, _t4, Math.fma(this.m21, _t10, -(this.m20 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateZXY(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZXY_orthogonal(angleX, angleY, angleZ, dest);
        return rotateZXY_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZXY(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateZXY(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZXY_orthogonal(angleX, angleY, angleZ, this);
        return rotateZXY_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZXY(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        float _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf1 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18));
        float _buf2 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t20, this.m21 * _t18));
        float _buf3 = Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11)));
        float _buf4 = Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11)));
        float _buf5 = Math.fma(this.m22, _t4, Math.fma(this.m21, _t10, -(this.m20 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_identity(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        d.m00 = _t0 * _t1;
        d.m10 = _t4 * _t0;
        d.m20 = -_t2;
        d.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        d.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        d.m21 = _t3 * _t0;
        d.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        d.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        d.m22 = _t5 * _t0;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_translation(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t3 * _t0;
        float _t7 = _t2 * _t1;
        float _t8 = _t5 * _t0;
        float _t9 = _t2 * _t4;
        d.m00 = Math.fma(_t0, _t1, -(this.m02 * _t2));
        d.m10 = Math.fma(_t4, _t0, -(this.m12 * _t2));
        d.m20 = -_t2;
        d.m01 = Math.fma(this.m02, _t6, Math.fma(_t7, _t3, -(_t4 * _t5)));
        d.m11 = Math.fma(this.m12, _t6, Math.fma(_t9, _t3, _t5 * _t1));
        d.m21 = _t6;
        d.m02 = Math.fma(this.m02, _t8, Math.fma(_t7, _t5, _t3 * _t4));
        d.m12 = Math.fma(this.m12, _t8, Math.fma(_t9, _t5, -(_t3 * _t1)));
        d.m22 = _t8;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_orthogonal(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        float _buf0 = Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7));
        float _buf1 = Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7));
        d.m20 = -_t0;
        float _buf2 = Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf3 = Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18));
        d.m21 = _t8;
        d.m02 = Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = _t13;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_general(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        float _buf0 = Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7));
        float _buf1 = Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7));
        float _buf2 = Math.fma(-this.m22, _t0, Math.fma(this.m20, _t6, this.m21 * _t7));
        float _buf3 = Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf4 = Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18));
        float _buf5 = Math.fma(this.m22, _t8, Math.fma(this.m20, _t20, this.m21 * _t18));
        d.m02 = Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t13, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
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
    public Float3x3 rotateZYX(float angleX, float angleY, float angleZ, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZYX_orthogonal(angleX, angleY, angleZ, dest);
        return rotateZYX_general(angleX, angleY, angleZ, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZYX(float angleX, float angleY, float angleZ) {
        if (Joml.RETURN_NEW) return rotateZYX(angleX, angleY, angleZ, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZYX_orthogonal(angleX, angleY, angleZ, this);
        return rotateZYX_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZYX(float angleX, float angleY, float angleZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        float _buf0 = Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7));
        float _buf1 = Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7));
        float _buf2 = Math.fma(-this.m22, _t0, Math.fma(this.m20, _t6, this.m21 * _t7));
        float _buf3 = Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18));
        float _buf4 = Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18));
        float _buf5 = Math.fma(this.m22, _t8, Math.fma(this.m20, _t20, this.m21 * _t18));
        d.m02 = Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m12 = Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m22 = Math.fma(this.m22, _t13, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 rotateZn180(@Mutated Float3x3 dest) {
        return rotateZ180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn180(@Mutated Double3x3 dest) {
        return rotateZ180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZn180() {
        return rotateZ180();
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
    public Float3x3 rotateZn270(@Mutated Float3x3 dest) {
        return rotateZ90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn270(@Mutated Double3x3 dest) {
        return rotateZ90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZn270() {
        return rotateZ90();
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
    public Float3x3 rotateZn90(@Mutated Float3x3 dest) {
        return rotateZ270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn90(@Mutated Double3x3 dest) {
        return rotateZ270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 rotateZn90() {
        return rotateZ270();
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
    public Float3x3 scale(Float2R v, @Mutated Float3x3 dest) {
        return scale(v.x(), v.y(), dest);
    }


    /**
     * Apply a scaling by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(Float2R v, @Mutated Double3x3 dest) {
        return scale(v.x(), v.y(), dest);
    }


    /**
     * Apply a scaling by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 scale(Float2R v) {
        return scale(v.x(), v.y());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity(float vX, float vY, @Mutated Float3x3 dest) {
        return preScale_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity_self(float vX, float vY, @Mutated Float3x3 dest) {
        return preScale_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = vY;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = vX;
        d.m11 = vY;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vX;
        d.m20 = 0.0f;
        d.m01 = this.m01 * vY;
        d.m11 = this.m11 * vY;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal_self(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vX;
        d.m01 = this.m01 * vY;
        d.m11 = this.m11 * vY;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_general(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vX;
        d.m20 = this.m20 * vX;
        d.m01 = this.m01 * vY;
        d.m11 = this.m11 * vY;
        d.m21 = this.m21 * vY;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 scale(float vX, float vY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(vX, vY, dest);
        return scale_general(vX, vY, dest);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 scale(float vX, float vY) {
        if (Joml.RETURN_NEW) return scale(vX, vY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal_self(vX, vY, this);
        return scale_general(vX, vY, this);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(float vX, float vY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00 * vX;
        d.m10 = this.m10 * vX;
        d.m20 = this.m20 * vX;
        d.m01 = this.m01 * vY;
        d.m11 = this.m11 * vY;
        d.m21 = this.m21 * vY;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity(float s, @Mutated Float3x3 dest) {
        return preScale_identity(s, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity_self(float s, @Mutated Float3x3 dest) {
        return preScale_identity_self(s, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation_self(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = 0.0f;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = 0.0f;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal_self(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_general(float s, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = s * this.m20;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = s * this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 scale(float s, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(s, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(s, dest);
        return scale_general(s, dest);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 scale(float s) {
        if (Joml.RETURN_NEW) return scale(s, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(s, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal_self(s, this);
        return scale_general(s, this);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(float s, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = s * this.m00;
        d.m10 = s * this.m10;
        d.m20 = s * this.m20;
        d.m01 = s * this.m01;
        d.m11 = s * this.m11;
        d.m21 = s * this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} to this matrix and store the result in {@code dest}.
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
    public Float3x3 scaleAround(float s, Float2R pivot, @Mutated Float3x3 dest) {
        return scaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(float s, Float2R pivot, @Mutated Double3x3 dest) {
        return scaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 scaleAround(float s, Float2R pivot) {
        return scaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preScaleAround_identity(s, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preScaleAround_identity_self(s, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = s;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-s, pivotX, this.m02 + pivotX);
        d.m12 = Math.fma(-s, pivotY, this.m12 + pivotY);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m02 = Math.fma(-s, pivotX, this.m02 + pivotX);
        d.m12 = Math.fma(-s, pivotY, this.m12 + pivotY);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _buf0 = s * this.m00;
        float _buf1 = s * this.m10;
        d.m20 = 0.0f;
        float _buf2 = s * this.m01;
        float _buf3 = s * this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02));
        d.m12 = Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal_self(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _buf0 = s * this.m00;
        float _buf1 = s * this.m10;
        float _buf2 = s * this.m01;
        float _buf3 = s * this.m11;
        d.m02 = Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02));
        d.m12 = Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_general(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _buf0 = s * this.m00;
        float _buf1 = s * this.m10;
        float _buf2 = s * this.m20;
        float _buf3 = s * this.m01;
        float _buf4 = s * this.m11;
        float _buf5 = s * this.m21;
        d.m02 = Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02));
        d.m12 = Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12));
        d.m22 = Math.fma(this.m20, _t0, Math.fma(this.m21, _t1, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 scaleAround(float s, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(s, pivotX, pivotY, dest);
        return scaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 scaleAround(float s, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(s, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal_self(s, pivotX, pivotY, this);
        return scaleAround_general(s, pivotX, pivotY, this);
    }


    /**
     * Apply a scaling by {@code s} of the x and y axes only (the 2D homogeneous
     * {@code diag(s, s, 1)}: the third row and column are left unscaled) about the pivot point
     * ({@code pivotX}, {@code pivotY}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(float s, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _buf0 = s * this.m00;
        float _buf1 = s * this.m10;
        float _buf2 = s * this.m20;
        float _buf3 = s * this.m01;
        float _buf4 = s * this.m11;
        float _buf5 = s * this.m21;
        d.m02 = Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02));
        d.m12 = Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12));
        d.m22 = Math.fma(this.m20, _t0, Math.fma(this.m21, _t1, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 scaleAround(Float2R s, Float2R pivot, @Mutated Float3x3 dest) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(Float2R s, Float2R pivot, @Mutated Double3x3 dest) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 scaleAround(Float2R s, Float2R pivot) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        return preScaleAround_identity_self(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = sY;
        d.m21 = 0.0f;
        d.m02 = Math.fma(-pivotX, sX, this.m02 + pivotX);
        d.m12 = Math.fma(-pivotY, sY, this.m12 + pivotY);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        d.m00 = sX;
        d.m11 = sY;
        d.m02 = Math.fma(-pivotX, sX, this.m02 + pivotX);
        d.m12 = Math.fma(-pivotY, sY, this.m12 + pivotY);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        float _buf0 = sX * this.m00;
        float _buf1 = sX * this.m10;
        d.m20 = 0.0f;
        float _buf2 = sY * this.m01;
        float _buf3 = sY * this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02));
        d.m12 = Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal_self(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        float _buf0 = sX * this.m00;
        float _buf1 = sX * this.m10;
        float _buf2 = sY * this.m01;
        float _buf3 = sY * this.m11;
        d.m02 = Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02));
        d.m12 = Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_general(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        float _buf0 = sX * this.m00;
        float _buf1 = sX * this.m10;
        float _buf2 = sX * this.m20;
        float _buf3 = sY * this.m01;
        float _buf4 = sY * this.m11;
        float _buf5 = sY * this.m21;
        d.m02 = Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02));
        d.m12 = Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12));
        d.m22 = Math.fma(this.m20, _t2, Math.fma(this.m21, _t3, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 scaleAround(float sX, float sY, float pivotX, float pivotY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
        return scaleAround_general(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 scaleAround(float sX, float sY, float pivotX, float pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(sX, sY, pivotX, pivotY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal_self(sX, sY, pivotX, pivotY, this);
        return scaleAround_general(sX, sY, pivotX, pivotY, this);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(float sX, float sY, float pivotX, float pivotY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        float _buf0 = sX * this.m00;
        float _buf1 = sX * this.m10;
        float _buf2 = sX * this.m20;
        float _buf3 = sY * this.m01;
        float _buf4 = sY * this.m11;
        float _buf5 = sY * this.m21;
        d.m02 = Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02));
        d.m12 = Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12));
        d.m22 = Math.fma(this.m20, _t2, Math.fma(this.m21, _t3, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
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
    public Float3x3 translate(Float2R v, @Mutated Float3x3 dest) {
        return translate(v.x(), v.y(), dest);
    }


    /**
     * Apply a translation by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 translate(Float2R v, @Mutated Double3x3 dest) {
        return translate(v.x(), v.y(), dest);
    }


    /**
     * Apply a translation by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Float3x3 translate(Float2R v) {
        return translate(v.x(), v.y());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_orthogonal_affine(float vX, float vY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        d.m20 = 0.0f;
        float _buf2 = this.m01;
        float _buf3 = this.m11;
        d.m21 = 0.0f;
        d.m02 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02));
        d.m12 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12));
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_orthogonal_affine_self(float vX, float vY, @Mutated Float3x3 dest, int _props) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        float _buf2 = this.m01;
        float _buf3 = this.m11;
        d.m02 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02));
        d.m12 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_identity(float vX, float vY, @Mutated Float3x3 dest) {
        return preTranslate_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_identity_self(float vX, float vY, @Mutated Float3x3 dest) {
        return preTranslate_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_translation(float vX, float vY, @Mutated Float3x3 dest) {
        return preTranslate_translation(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_translation_self(float vX, float vY, @Mutated Float3x3 dest) {
        return preTranslate_translation_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_general(float vX, float vY, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        float _buf2 = this.m20;
        float _buf3 = this.m01;
        float _buf4 = this.m11;
        float _buf5 = this.m21;
        d.m02 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02));
        d.m12 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12));
        d.m22 = Math.fma(this.m20, vX, Math.fma(this.m21, vY, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 translate(float vX, float vY, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return translate_orthogonal_affine(vX, vY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return translate_general(vX, vY, dest);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 translate(float vX, float vY) {
        if (Joml.RETURN_NEW) return translate(vX, vY, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return translate_orthogonal_affine_self(vX, vY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return translate_general(vX, vY, this);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 translate(float vX, float vY, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = this.m00;
        float _buf1 = this.m10;
        float _buf2 = this.m20;
        float _buf3 = this.m01;
        float _buf4 = this.m11;
        float _buf5 = this.m21;
        d.m02 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02));
        d.m12 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12));
        d.m22 = Math.fma(this.m20, vX, Math.fma(this.m21, vY, this.m22));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_identity(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        d.m00 = 2.0f * _t0_inv;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f * _t1_inv;
        d.m21 = 0.0f;
        d.m02 = -((left + right) * _t0_inv);
        d.m12 = -((bottom + top) * _t1_inv);
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Float3x3 view_identity_self(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        d.m00 = 2.0f * _t0_inv;
        d.m11 = 2.0f * _t1_inv;
        d.m02 = -((left + right) * _t0_inv);
        d.m12 = -((bottom + top) * _t1_inv);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_translation(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        d.m00 = 2.0f * _t0_inv;
        d.m10 = 0.0f;
        d.m20 = 0.0f;
        d.m01 = 0.0f;
        d.m11 = 2.0f * _t1_inv;
        d.m21 = 0.0f;
        d.m02 = this.m02 - (left + right) * _t0_inv;
        d.m12 = this.m12 - (bottom + top) * _t1_inv;
        d.m22 = 1.0f;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Float3x3 view_translation_self(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        d.m00 = 2.0f * _t0_inv;
        d.m11 = 2.0f * _t1_inv;
        d.m02 = this.m02 - (left + right) * _t0_inv;
        d.m12 = this.m12 - (bottom + top) * _t1_inv;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_orthogonal(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        d.m20 = 0.0f;
        float _buf2 = 2.0f * this.m01 * _t1_inv;
        float _buf3 = 2.0f * this.m11 * _t1_inv;
        d.m21 = 0.0f;
        d.m02 = this.m02 - this.m00 * _t2 * _t0_inv - this.m01 * _t3 * _t1_inv;
        d.m12 = this.m12 - this.m10 * _t2 * _t0_inv - this.m11 * _t3 * _t1_inv;
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Float3x3 view_orthogonal_self(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        float _buf2 = 2.0f * this.m01 * _t1_inv;
        float _buf3 = 2.0f * this.m11 * _t1_inv;
        d.m02 = this.m02 - this.m00 * _t2 * _t0_inv - this.m01 * _t3 * _t1_inv;
        d.m12 = this.m12 - this.m10 * _t2 * _t0_inv - this.m11 * _t3 * _t1_inv;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_affine(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        d.m20 = 0.0f;
        float _buf2 = 2.0f * this.m01 * _t1_inv;
        float _buf3 = 2.0f * this.m11 * _t1_inv;
        d.m21 = 0.0f;
        d.m02 = this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv);
        d.m12 = this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv);
        d.m22 = 1.0f;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Float3x3 view_affine_self(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        float _buf2 = 2.0f * this.m01 * _t1_inv;
        float _buf3 = 2.0f * this.m11 * _t1_inv;
        d.m02 = this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv);
        d.m12 = this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_general(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        float _buf2 = 2.0f * this.m20 * _t0_inv;
        float _buf3 = 2.0f * this.m01 * _t1_inv;
        float _buf4 = 2.0f * this.m11 * _t1_inv;
        float _buf5 = 2.0f * this.m21 * _t1_inv;
        d.m02 = this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv);
        d.m12 = this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv);
        d.m22 = this.m22 + (-(this.m20 * _t2 * _t0_inv) - this.m21 * _t3 * _t1_inv);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 view(float left, float right, float bottom, float top, @Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity(left, right, bottom, top, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation(left, right, bottom, top, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal(left, right, bottom, top, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return view_affine(left, right, bottom, top, dest);
        return view_general(left, right, bottom, top, dest);
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Float3x3 view(float left, float right, float bottom, float top) {
        if (Joml.RETURN_NEW) return view(left, right, bottom, top, Joml.float3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return view_affine_self(left, right, bottom, top, this);
        return view_general(left, right, bottom, top, this);
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 view(float left, float right, float bottom, float top, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        float _buf0 = 2.0f * this.m00 * _t0_inv;
        float _buf1 = 2.0f * this.m10 * _t0_inv;
        float _buf2 = 2.0f * this.m20 * _t0_inv;
        float _buf3 = 2.0f * this.m01 * _t1_inv;
        float _buf4 = 2.0f * this.m11 * _t1_inv;
        float _buf5 = 2.0f * this.m21 * _t1_inv;
        d.m02 = this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv);
        d.m12 = this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv);
        d.m22 = this.m22 + (-(this.m20 * _t2 * _t0_inv) - this.m21 * _t3 * _t1_inv);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.properties = 0;
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 mul(Float3R v, @Mutated Float3 dest) {
        return mul(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(Float3R v, @Mutated Double3 dest) {
        return mul(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_identity(float vX, float vY, float vZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = vX;
        d.y = vY;
        d.z = vZ;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_translation(float vX, float vY, float vZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.fma(this.m02, vZ, vX);
        d.y = Math.fma(this.m12, vZ, vY);
        d.z = vZ;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_general(float vX, float vY, float vZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY));
        d.y = Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY));
        d.z = Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY));
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 mul(float vX, float vY, float vZ, @Mutated Float3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ, dest);
        return mul_general(vX, vY, vZ, dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(float vX, float vY, float vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY));
        d.y = Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY));
        d.z = Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY));
        return d;
    }

    public float m00() { return this.m00; }
    public float m01() { return this.m01; }
    public float m02() { return this.m02; }
    public float m10() { return this.m10; }
    public float m11() { return this.m11; }
    public float m12() { return this.m12; }
    public float m20() { return this.m20; }
    public float m21() { return this.m21; }
    public float m22() { return this.m22; }

    @Override public String toString() {
        return "Float3x3(\n    " + m00() + ", " + m01() + ", " + m02() + "\n    " + m10() + ", " + m11() + ", " + m12() + "\n    " + m20() + ", " + m21() + ", " + m22() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3x3Impl)) return false;
        Float3x3Impl o = (Float3x3Impl) obj;
        return Float.floatToIntBits(m00) == Float.floatToIntBits(o.m00)
            && Float.floatToIntBits(m01) == Float.floatToIntBits(o.m01)
            && Float.floatToIntBits(m02) == Float.floatToIntBits(o.m02)
            && Float.floatToIntBits(m10) == Float.floatToIntBits(o.m10)
            && Float.floatToIntBits(m11) == Float.floatToIntBits(o.m11)
            && Float.floatToIntBits(m12) == Float.floatToIntBits(o.m12)
            && Float.floatToIntBits(m20) == Float.floatToIntBits(o.m20)
            && Float.floatToIntBits(m21) == Float.floatToIntBits(o.m21)
            && Float.floatToIntBits(m22) == Float.floatToIntBits(o.m22);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(m00);
        h = 31 * h + Float.floatToIntBits(m01);
        h = 31 * h + Float.floatToIntBits(m02);
        h = 31 * h + Float.floatToIntBits(m10);
        h = 31 * h + Float.floatToIntBits(m11);
        h = 31 * h + Float.floatToIntBits(m12);
        h = 31 * h + Float.floatToIntBits(m20);
        h = 31 * h + Float.floatToIntBits(m21);
        h = 31 * h + Float.floatToIntBits(m22);
        return h;
    }

    @Override public boolean isFinite() {
        return Float.isFinite(m00)
            && Float.isFinite(m01)
            && Float.isFinite(m02)
            && Float.isFinite(m10)
            && Float.isFinite(m11)
            && Float.isFinite(m12)
            && Float.isFinite(m20)
            && Float.isFinite(m21)
            && Float.isFinite(m22);
    }

    @Override public boolean equalsEpsilon(Float3x3R other, float epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m02 - other.m02()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m12 - other.m12()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m22 - other.m22()) <= epsilon;
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m01;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m02;
        dest[offset + 7] = this.m12;
        dest[offset + 8] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadCM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m21 = src[offset + 5];
        this.m02 = src[offset + 6];
        this.m12 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float3x3 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Float3x3 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Float3x3 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Float3x3 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
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
        return dest;
    }
    public @Mutated Float3x3 loadCM(double[] src, int offset) {
        this.m00 = (float) src[offset + 0];
        this.m10 = (float) src[offset + 1];
        this.m20 = (float) src[offset + 2];
        this.m01 = (float) src[offset + 3];
        this.m11 = (float) src[offset + 4];
        this.m21 = (float) src[offset + 5];
        this.m02 = (float) src[offset + 6];
        this.m12 = (float) src[offset + 7];
        this.m22 = (float) src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float3x3 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf);
    }
    public Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf);
    }
    public Float3x3 storeCMDoubleUnsafe(long address) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address);
    }
    @Mutated public Float3x3 loadCMDoubleUnsafe(long address) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m10;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m12;
        dest[offset + 6] = this.m20;
        dest[offset + 7] = this.m21;
        dest[offset + 8] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadRM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m12 = src[offset + 5];
        this.m20 = src[offset + 6];
        this.m21 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float3x3 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Float3x3 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Float3x3 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Float3x3 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m10;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m12;
        dest[offset + 6] = this.m20;
        dest[offset + 7] = this.m21;
        dest[offset + 8] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadRM(double[] src, int offset) {
        this.m00 = (float) src[offset + 0];
        this.m01 = (float) src[offset + 1];
        this.m02 = (float) src[offset + 2];
        this.m10 = (float) src[offset + 3];
        this.m11 = (float) src[offset + 4];
        this.m12 = (float) src[offset + 5];
        this.m20 = (float) src[offset + 6];
        this.m21 = (float) src[offset + 7];
        this.m22 = (float) src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float3x3 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf);
    }
    public Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf);
    }
    public Float3x3 storeRMDoubleUnsafe(long address) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address);
    }
    @Mutated public Float3x3 loadRMDoubleUnsafe(long address) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m02 = src[_p2];
        this.m12 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float3x3 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Float3x3 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Float3x3 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Float3x3 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = (float) src[offset];
        this.m10 = (float) src[offset + 1];
        this.m20 = (float) src[offset + 2];
        this.m01 = (float) src[_p1];
        this.m11 = (float) src[_p1 + 1];
        this.m21 = (float) src[_p1 + 2];
        this.m02 = (float) src[_p2];
        this.m12 = (float) src[_p2 + 1];
        this.m22 = (float) src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float3x3 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float3x3 storeCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float3x3 loadCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m12 = src[_p1 + 2];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float3x3 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Float3x3 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Float3x3 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Float3x3 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        return dest;
    }
    public @Mutated Float3x3 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = (float) src[offset];
        this.m01 = (float) src[offset + 1];
        this.m02 = (float) src[offset + 2];
        this.m10 = (float) src[_p1];
        this.m11 = (float) src[_p1 + 1];
        this.m12 = (float) src[_p1 + 2];
        this.m20 = (float) src[_p2];
        this.m21 = (float) src[_p2 + 1];
        this.m22 = (float) src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float3x3 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float3x3 storeRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float3x3 loadRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address, stride);
    }

    public float[] storeCM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }
    public FloatBuffer storeCM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public Float3x3 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }

    public double[] storeCM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }
    public DoubleBuffer storeCM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4DoubleAbsolute(this, index, buf);
    }
    public Float3x3 storeCM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeCM4x4DoubleUnsafe(this, address);
    }

    public float[] storeRM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }
    public FloatBuffer storeRM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public Float3x3 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }

    public double[] storeRM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }
    public DoubleBuffer storeRM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4DoubleAbsolute(this, index, buf);
    }
    public Float3x3 storeRM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeRM4x4DoubleUnsafe(this, address);
    }

}
