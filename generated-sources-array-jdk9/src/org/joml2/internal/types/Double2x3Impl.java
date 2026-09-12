package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link Double2x3} backed by a {@code double[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Double2x3Impl implements Double2x3 {

    public double[] data;
    public int properties;
    static final Double2x3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double2x3BbOpsUnsafe()
                    : new Double2x3BbOpsApi();
    static final Double2x3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double2x3RawOpsUnsafe()
                    : new Double2x3RawOpsApi();

    public Double2x3Impl() {
        data = new double[6];
        data[0] = 1;
        data[3] = 1;
        properties = Joml.BIT_IDENTITY;
    }

    public Double2x3Impl(double m00, double m01, double m02, double m10, double m11, double m12) {
        double[] dd = this.data = new double[6];
        dd[0] = m00;
        dd[1] = m10;
        dd[2] = m01;
        dd[3] = m11;
        dd[4] = m02;
        dd[5] = m12;
        this.properties = determineProperties();
    }

    public Double2x3Impl(Double2x3R src) {
        Double2x3Impl s = (Double2x3Impl) src;
        this.data = s.data.clone();
        this.properties = s.properties;
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
     * This is a pure query: it does not update this matrix's cached property bits.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.data[0] != 1 || this.data[2] != 0 || this.data[1] != 0 || this.data[3] != 1) return 1;
        if (this.data[4] != 0 || this.data[5] != 0) return 7;
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
    private Double2 getColumn_identity(int col, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        double _idxSw0;
        double _idxSw1;
        switch (col) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; break;
            case 2: _idxSw0 = 0.0; _idxSw1 = 0.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw0;
        dd[1] = _idxSw1;
        return dest;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double2 getColumn_translation(int col, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        double _idxSw2;
        double _idxSw3;
        switch (col) {
            case 0: _idxSw2 = 1.0; _idxSw3 = 0.0; break;
            case 1: _idxSw2 = 0.0; _idxSw3 = 1.0; break;
            case 2: _idxSw2 = sd[4]; _idxSw3 = sd[5]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw2;
        dd[1] = _idxSw3;
        return dest;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double2 getColumn_general(int col, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        double _idxSw4;
        double _idxSw5;
        switch (col) {
            case 0: _idxSw4 = sd[0]; _idxSw5 = sd[1]; break;
            case 1: _idxSw4 = sd[2]; _idxSw5 = sd[3]; break;
            case 2: _idxSw4 = sd[4]; _idxSw5 = sd[5]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw4;
        dd[1] = _idxSw5;
        return dest;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double2 getColumn(int col, @Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getColumn_translation(col, dest);
        return getColumn_general(col, dest);
    }


    /**
     * Compute the rotation angle in radians ({@code atan2(m10, m00)}) of this matrix; for a matrix
     * carrying scale the rotation angle is still recovered as long as the X-axis scale is positive.
     *
     * @return the rotation angle in radians ({@code atan2(m10, m00)}) of this matrix; for a matrix
     *        carrying scale the rotation angle is still recovered as long as the X-axis scale is
     *        positive
     */
    public double getRotationAngle() {
        double[] sd = this.data;
        return Math.atan2(sd[1], sd[0]);
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_identity(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw0;
        double _idxSw1;
        switch (row) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw0;
        dd[1] = _idxSw1;
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_translation(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw2;
        double _idxSw3;
        double _idxSw4;
        switch (row) {
            case 0: _idxSw2 = 1.0; _idxSw3 = 0.0; _idxSw4 = sd[4]; break;
            case 1: _idxSw2 = 0.0; _idxSw3 = 1.0; _idxSw4 = sd[5]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw2;
        dd[1] = _idxSw3;
        dd[2] = _idxSw4;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_general(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw5;
        double _idxSw6;
        double _idxSw7;
        switch (row) {
            case 0: _idxSw5 = sd[0]; _idxSw6 = sd[2]; _idxSw7 = sd[4]; break;
            case 1: _idxSw5 = sd[1]; _idxSw6 = sd[3]; _idxSw7 = sd[5]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw5;
        dd[1] = _idxSw6;
        dd[2] = _idxSw7;
        return dest;
    }


    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Double3 getRow(int row, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getRow_translation(row, dest);
        return getRow_general(row, dest);
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double2 getTranslation_identity(@Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double2 getTranslation_general(@Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[4];
        dd[1] = sd[5];
        return dest;
    }


    /**
     * Get the translation of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getTranslation(@Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getTranslation_identity(dest);
        return getTranslation_general(dest);
    }


    /**
     * Compute the determinant of the linear part (the upper-left square block) of this matrix.
     *
     * @return the determinant of the linear part (the upper-left square block) of this matrix
     */
    public double determinant() {
        double[] sd = this.data;
        return Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public double frobeniusNorm() {
        double[] sd = this.data;
        return Math.sqrt(Math.fma(sd[5], sd[5], Math.fma(sd[3], sd[3], Math.fma(sd[1], sd[1], Math.fma(sd[4], sd[4], Math.fma(sd[0], sd[0], sd[2] * sd[2]))))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_identity(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_identity_self(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        ((Double2x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_translation(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_translation_self(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_orthogonal(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[3];
        double _buf0 = -sd[1];
        dd[2] = sd[1];
        double _buf1 = sd[3];
        double _buf2 = Math.fma(-sd[4], sd[3], -(sd[1] * sd[5]));
        dd[5] = Math.fma(sd[4], sd[1], -(sd[3] * sd[5]));
        dd[1] = _buf0;
        dd[3] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double2x3 invert_general(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[3] * _t2_inv;
        double _buf1 = -(sd[1] * _t2_inv);
        double _buf2 = -(sd[2] * _t2_inv);
        double _buf3 = sd[0] * _t2_inv;
        double _buf4 = -(Math.fma(sd[4], sd[3], -(sd[2] * sd[5])) * _t2_inv);
        dd[5] = -(Math.fma(sd[0], sd[5], -(sd[4] * sd[1])) * _t2_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 invert(@Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal(dest);
        return invert_general(dest);
    }


    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 invert() {
        if (Joml.RETURN_NEW) return invert(Joml.double2x3());
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
    private Double2x3 invertProduct_general(Double2x3R other, @Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t6 = Math.fma(otherData[2], sd[1], otherData[3] * sd[3]);
        double _t7 = Math.fma(otherData[0], sd[0], otherData[1] * sd[2]);
        double _t8 = Math.fma(otherData[0], sd[1], otherData[1] * sd[3]);
        double _t9 = Math.fma(otherData[2], sd[0], otherData[3] * sd[2]);
        double _t10 = Math.fma(otherData[4], sd[0], Math.fma(otherData[5], sd[2], sd[4]));
        double _t11 = Math.fma(otherData[4], sd[1], Math.fma(otherData[5], sd[3], sd[5]));
        double _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        double _t14_inv = 1.0 / _t14;
        dd[0] = _t6 * _t14_inv;
        dd[1] = -(_t8 * _t14_inv);
        dd[2] = -(_t9 * _t14_inv);
        dd[3] = _t7 * _t14_inv;
        dd[4] = -(Math.fma(_t10, _t6, -(_t11 * _t9)) * _t14_inv);
        dd[5] = -(Math.fma(_t11, _t7, -(_t10 * _t8)) * _t14_inv);
        ((Double2x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t2 = Math.fma(otherData[0], otherData[3], -(otherData[2] * otherData[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = otherData[3] * _t2_inv;
        double _buf1 = -(otherData[1] * _t2_inv);
        double _buf2 = -(otherData[2] * _t2_inv);
        double _buf3 = otherData[0] * _t2_inv;
        double _buf4 = -(Math.fma(otherData[4], otherData[3], -(otherData[2] * otherData[5])) * _t2_inv);
        dd[5] = -(Math.fma(otherData[0], otherData[5], -(otherData[4] * otherData[1])) * _t2_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t1 = otherData[4] + sd[4];
        double _t2 = otherData[5] + sd[5];
        double _t4 = Math.fma(otherData[0], otherData[3], -(otherData[2] * otherData[1]));
        double _t4_inv = 1.0 / _t4;
        double _buf0 = otherData[3] * _t4_inv;
        double _buf1 = -(otherData[1] * _t4_inv);
        double _buf2 = -(otherData[2] * _t4_inv);
        double _buf3 = otherData[0] * _t4_inv;
        dd[4] = -(Math.fma(otherData[3], _t1, -(otherData[2] * _t2)) * _t4_inv);
        dd[5] = -(Math.fma(otherData[0], _t2, -(otherData[1] * _t1)) * _t4_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_identity_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_identity_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = -otherData[4];
        dd[5] = -otherData[5];
        ((Double2x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_translation_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_translation_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = -(otherData[4] + sd[4]);
        dd[5] = -(otherData[5] + sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_orthogonal_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[3];
        double _buf0 = -sd[1];
        dd[2] = sd[1];
        double _buf1 = sd[3];
        double _buf2 = Math.fma(-sd[4], sd[3], -(sd[1] * sd[5]));
        dd[5] = Math.fma(sd[4], sd[1], -(sd[3] * sd[5]));
        dd[1] = _buf0;
        dd[3] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_orthogonal_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = -sd[1];
        dd[0] = sd[3];
        double _buf0 = _t0;
        dd[2] = sd[1];
        double _buf1 = sd[3];
        double _buf2 = Math.fma(_t0, sd[5], Math.fma(-sd[4], sd[3], -otherData[4]));
        dd[5] = Math.fma(sd[4], sd[1], Math.fma(-sd[3], sd[5], -otherData[5]));
        dd[1] = _buf0;
        dd[3] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_general_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[3] * _t2_inv;
        double _buf1 = -(sd[1] * _t2_inv);
        double _buf2 = -(sd[2] * _t2_inv);
        double _buf3 = sd[0] * _t2_inv;
        double _buf4 = -(Math.fma(sd[4], sd[3], -(sd[2] * sd[5])) * _t2_inv);
        dd[5] = -(Math.fma(sd[0], sd[5], -(sd[4] * sd[1])) * _t2_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double2x3 invertProduct_general_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t4 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        double _t4_inv = 1.0 / _t4;
        double _t5 = Math.fma(otherData[4], sd[0], Math.fma(otherData[5], sd[2], sd[4]));
        double _t6 = Math.fma(otherData[4], sd[1], Math.fma(otherData[5], sd[3], sd[5]));
        double _buf0 = sd[3] * _t4_inv;
        double _buf1 = -(sd[1] * _t4_inv);
        double _buf2 = -(sd[2] * _t4_inv);
        double _buf3 = sd[0] * _t4_inv;
        dd[4] = -(Math.fma(sd[3], _t5, -(sd[2] * _t6)) * _t4_inv);
        dd[5] = -(Math.fma(sd[0], _t6, -(sd[1] * _t5)) * _t4_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
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
    public Double2x3 invertProduct(Double2x3R other, @Mutated Double2x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
    @Mutated public Double2x3 invertProduct(Double2x3R other) {
        if (Joml.RETURN_NEW) return invertProduct(other, Joml.double2x3());
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
     * {@code m10}, {@code m11}, {@code m12}) and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 invertProduct(double m00, double m01, double m02, double m10, double m11, double m12, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t6 = Math.fma(m01, sd[1], m11 * sd[3]);
        double _t7 = Math.fma(m00, sd[0], m10 * sd[2]);
        double _t8 = Math.fma(m00, sd[1], m10 * sd[3]);
        double _t9 = Math.fma(m01, sd[0], m11 * sd[2]);
        double _t10 = Math.fma(m02, sd[0], Math.fma(m12, sd[2], sd[4]));
        double _t11 = Math.fma(m02, sd[1], Math.fma(m12, sd[3], sd[5]));
        double _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        double _t14_inv = 1.0 / _t14;
        dd[0] = _t6 * _t14_inv;
        dd[1] = -(_t8 * _t14_inv);
        dd[2] = -(_t9 * _t14_inv);
        dd[3] = _t7 * _t14_inv;
        dd[4] = -(Math.fma(_t10, _t6, -(_t11 * _t9)) * _t14_inv);
        dd[5] = -(Math.fma(_t11, _t7, -(_t10 * _t8)) * _t14_inv);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x2 transpose_identity(@Mutated Double3x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x2Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x2 transpose_translation(@Mutated Double3x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x2Impl) dest).data;
        dd[0] = 1.0;
        double _buf0 = 0.0;
        dd[2] = sd[4];
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = sd[5];
        dd[1] = _buf0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x2 transpose_general(@Mutated Double3x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x2Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[2];
        double _buf1 = sd[4];
        dd[3] = sd[1];
        dd[4] = sd[3];
        dd[5] = sd[5];
        dd[1] = _buf0;
        dd[2] = _buf1;
        return dest;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x2 transpose(@Mutated Double3x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation(dest);
        return transpose_general(dest);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_general(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = otherData[1] + sd[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = otherData[3] + sd[3];
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = 1.0 + otherData[3];
        dd[4] = otherData[4];
        dd[5] = otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = 1.0 + otherData[3];
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_identity_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_identity_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0;
        dd[4] = otherData[4];
        dd[5] = otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_translation_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_translation_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0;
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_orthogonal_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0 + sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double2x3 add_orthogonal_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0 + sd[3];
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 add(Double2x3R other, @Mutated Double2x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 add(Double2x3R other) {
        if (Joml.RETURN_NEW) return add(other, Joml.double2x3());
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12}) to this
     * matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 add(double m00, double m01, double m02, double m10, double m11, double m12, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = m00 + sd[0];
        dd[1] = m10 + sd[1];
        dd[2] = m01 + sd[2];
        dd[3] = m11 + sd[3];
        dd[4] = m02 + sd[4];
        dd[5] = m12 + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_identity(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = -1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_identity_self(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = -1.0;
        dd[3] = -1.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_translation(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = -1.0;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_translation_self(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = -1.0;
        dd[3] = -1.0;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_orthogonal(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = -sd[3];
        dd[0] = _t0;
        double _buf0 = -sd[1];
        dd[2] = sd[1];
        dd[3] = _t0;
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[1] = _buf0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double2x3 negate_general(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 negate(@Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal(dest);
        return negate_general(dest);
    }


    /**
     * Negate this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 negate() {
        if (Joml.RETURN_NEW) return negate(Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal(this);
        return negate_general(this);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_general(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = sd[1] - otherData[1];
        dd[2] = sd[2] - otherData[2];
        dd[3] = sd[3] - otherData[3];
        dd[4] = sd[4] - otherData[4];
        dd[5] = sd[5] - otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0 - otherData[0];
        dd[1] = -otherData[1];
        dd[2] = -otherData[2];
        dd[3] = 1.0 - otherData[3];
        dd[4] = -otherData[4];
        dd[5] = -otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_identity_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_identity_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -otherData[4];
        dd[5] = -otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_translation_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_translation_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sd[4] - otherData[4];
        dd[5] = sd[5] - otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_orthogonal_identity(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3] - 1.0;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double2x3 sub_orthogonal_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3] - 1.0;
        dd[4] = sd[4] - otherData[4];
        dd[5] = sd[5] - otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 sub(Double2x3R other, @Mutated Double2x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
        return sub_general(other, dest);
    }


    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 sub(Double2x3R other) {
        if (Joml.RETURN_NEW) return sub(other, Joml.double2x3());
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
        return sub_general(other, this);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12}) from
     * this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 sub(double m00, double m01, double m02, double m10, double m11, double m12, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] - m00;
        dd[1] = sd[1] - m10;
        dd[2] = sd[2] - m01;
        dd[3] = sd[3] - m11;
        dd[4] = sd[4] - m02;
        dd[5] = sd[5] - m12;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Double2x3 set(Double2x3R v) {
        double[] dd = this.data;
        double[] vData = ((Double2x3Impl) v).data;
        dd[0] = vData[0];
        dd[1] = vData[1];
        dd[2] = vData[2];
        dd[3] = vData[3];
        dd[4] = vData[4];
        dd[5] = vData[5];
        ((Double2x3Impl) this).properties = ((Double2x3Impl) v).properties;
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
     * @return this
     */
    @Mutated public Double2x3 set(double m00, double m01, double m02, double m10, double m11, double m12) {
        double[] dd = this.data;
        dd[0] = m00;
        dd[1] = m10;
        dd[2] = m01;
        dd[3] = m11;
        dd[4] = m02;
        dd[5] = m12;
        ((Double2x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x2 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double2x3 set(Double2x2R m) {
        double[] dd = this.data;
        double[] mData = ((Double2x2Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = mData[2];
        dd[3] = mData[3];
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 3x3 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double2x3 set(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = mData[3];
        dd[3] = mData[4];
        dd[4] = mData[6];
        dd[5] = mData[7];
        ((Double2x3Impl) this).properties = determineProperties();
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
    public Double2x3 withTranslation(Double2R t, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 withTranslation(Double2R t) {
        return withTranslation(t.x(), t.y());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double2x3 withTranslation_identity(double tX, double tY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = tX;
        dd[5] = tY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Double2x3 withTranslation_identity_self(double tX, double tY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[4] = tX;
        dd[5] = tY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double2x3 withTranslation_orthogonal(double tX, double tY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = tX;
        dd[5] = tY;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double2x3 withTranslation_general(double tX, double tY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = tX;
        dd[5] = tY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 withTranslation(double tX, double tY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY, dest);
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
    @Mutated public Double2x3 withTranslation(double tX, double tY) {
        if (Joml.RETURN_NEW) return withTranslation(tX, tY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity_self(tX, tY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY, this);
        return withTranslation_general(tX, tY, this);
    }


    /**
     * Convert this matrix to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x3 toFloat(@Mutated Float2x3 dest) {
        double[] sd = this.data;
        float[] dd = ((Float2x3Impl) dest).data;
        dd[0] = (float) (sd[0]);
        dd[1] = (float) (sd[1]);
        dd[2] = (float) (sd[2]);
        dd[3] = (float) (sd[3]);
        dd[4] = (float) (sd[4]);
        dd[5] = (float) (sd[5]);
        ((Float2x3Impl) dest).properties = this.properties;
        return dest;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Double2x2 to2x2_identity(@Mutated Double2x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        ((Double2x2Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Double2x2 to2x2_general(@Mutated Double2x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Extract the upper-left 2x2 linear block of this matrix (dropping the translation column) and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 to2x2(@Mutated Double2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x2_identity(dest);
        return to2x2_general(dest);
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Double3x3 to3x3_orthogonal_general(@Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Double3x3 to3x3_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Double3x3 to3x3_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Extend this matrix to a 3x3 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 to3x3(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to3x3_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x3_translation(dest);
        return to3x3_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Double2x3 makeIdentity() {
        double[] dd = this.data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) this).properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_general(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherData[1] - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherData[3] - sd[3], sd[3]);
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = Math.fma(t, otherData[5] - sd[5], sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_identity(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = t * otherData[2];
        dd[3] = Math.fma(t, otherData[3] - 1.0, 1.0);
        dd[4] = t * otherData[4];
        dd[5] = t * otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_translation(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = t * otherData[2];
        dd[3] = Math.fma(t, otherData[3] - 1.0, 1.0);
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = Math.fma(t, otherData[5] - sd[5], sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_identity_identity(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_identity_translation(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = t * otherData[4];
        dd[5] = t * otherData[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_translation_identity(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = Math.fma(-t, sd[4], sd[4]);
        dd[5] = Math.fma(-t, sd[5], sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double2x3 lerp_translation_translation(Double2x3R other, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = Math.fma(t, otherData[5] - sd[5], sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
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
    public Double2x3 lerp(Double2x3R other, double t, @Mutated Double2x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 lerp(Double2x3R other, double t) {
        if (Joml.RETURN_NEW) return lerp(other, t, Joml.double2x3());
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
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
     * {@code m10}, {@code m11}, {@code m12}) using the interpolation factor {@code t} and store the
     * result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 lerp(double m00, double m01, double m02, double m10, double m11, double m12, double t, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(t, m00 - sd[0], sd[0]);
        dd[1] = Math.fma(t, m10 - sd[1], sd[1]);
        dd[2] = Math.fma(t, m01 - sd[2], sd[2]);
        dd[3] = Math.fma(t, m11 - sd[3], sd[3]);
        dd[4] = Math.fma(t, m02 - sd[4], sd[4]);
        dd[5] = Math.fma(t, m12 - sd[5], sd[5]);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_general(Double2x3R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[2]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[3]);
        double _buf2 = Math.fma(rightData[2], sd[0], rightData[3] * sd[2]);
        double _buf3 = Math.fma(rightData[2], sd[1], rightData[3] * sd[3]);
        double _buf4 = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[2], sd[4]));
        dd[5] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[3], sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_translation(Double2x3R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = rightData[2];
        dd[3] = rightData[3];
        dd[4] = rightData[4] + sd[4];
        dd[5] = rightData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_orthogonal(Double2x3R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[3], -(rightData[1] * sd[1]));
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[3]);
        double _buf2 = Math.fma(rightData[2], sd[3], -(rightData[3] * sd[1]));
        double _buf3 = Math.fma(rightData[2], sd[1], rightData[3] * sd[3]);
        double _buf4 = Math.fma(-rightData[5], sd[1], Math.fma(rightData[4], sd[3], sd[4]));
        dd[5] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[3], sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_translation_translation(Double2x3R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = rightData[4] + sd[4];
        dd[5] = rightData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_orthogonal_translation(Double2x3R right, @Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        double _buf4 = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[2], sd[4]));
        dd[5] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[3], sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = _props;
        return dest;
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
    public Double2x3 mul(Double2x3R right, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Double2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
        return mul_general(right, dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 mul(Double2x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(right);
        int q = ((Double2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
        return mul_general(right, this);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}) and store the result in {@code dest}.
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
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 mul(double m00, double m01, double m02, double m10, double m11, double m12, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(m00, sd[0], m10 * sd[2]);
        double _buf1 = Math.fma(m00, sd[1], m10 * sd[3]);
        double _buf2 = Math.fma(m01, sd[0], m11 * sd[2]);
        double _buf3 = Math.fma(m01, sd[1], m11 * sd[3]);
        dd[4] = Math.fma(m02, sd[0], Math.fma(m12, sd[2], sd[4]));
        dd[5] = Math.fma(m02, sd[1], Math.fma(m12, sd[3], sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_identity(Double2x2R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = rightData[2];
        dd[3] = rightData[3];
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double2x3 mul_identity_self(Double2x2R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = rightData[2];
        dd[3] = rightData[3];
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_translation(Double2x2R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = rightData[2];
        dd[3] = rightData[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_orthogonal(Double2x2R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(rightData[0], sd[3], -(rightData[1] * sd[1]));
        double _buf0 = Math.fma(rightData[0], sd[1], rightData[1] * sd[3]);
        dd[2] = Math.fma(rightData[2], sd[3], -(rightData[3] * sd[1]));
        dd[3] = Math.fma(rightData[2], sd[1], rightData[3] * sd[3]);
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[1] = _buf0;
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2x3 mul_general(Double2x2R right, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[2]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[3]);
        dd[2] = Math.fma(rightData[2], sd[0], rightData[3] * sd[2]);
        dd[3] = Math.fma(rightData[2], sd[1], rightData[3] * sd[3]);
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 mul(Double2x2R right, @Mutated Double2x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 mul(Double2x2R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double2x3());
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
    private Double3x3 mul_general(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[2], sd[4], Math.fma(rightData[0], sd[0], rightData[1] * sd[2]));
        double _buf1 = Math.fma(rightData[2], sd[5], Math.fma(rightData[0], sd[1], rightData[1] * sd[3]));
        dd[2] = rightData[2];
        double _buf2 = Math.fma(rightData[5], sd[4], Math.fma(rightData[3], sd[0], rightData[4] * sd[2]));
        double _buf3 = Math.fma(rightData[5], sd[5], Math.fma(rightData[3], sd[1], rightData[4] * sd[3]));
        dd[5] = rightData[5];
        double _buf4 = Math.fma(rightData[8], sd[4], Math.fma(rightData[6], sd[0], rightData[7] * sd[2]));
        dd[7] = Math.fma(rightData[8], sd[5], Math.fma(rightData[6], sd[1], rightData[7] * sd[3]));
        dd[8] = rightData[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(rightData[2], sd[4], rightData[0]);
        dd[1] = Math.fma(rightData[2], sd[5], rightData[1]);
        dd[2] = rightData[2];
        dd[3] = Math.fma(rightData[5], sd[4], rightData[3]);
        dd[4] = Math.fma(rightData[5], sd[5], rightData[4]);
        dd[5] = rightData[5];
        dd[6] = Math.fma(rightData[8], sd[4], rightData[6]);
        dd[7] = Math.fma(rightData[8], sd[5], rightData[7]);
        dd[8] = rightData[8];
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[2], sd[4], Math.fma(rightData[0], sd[3], -(rightData[1] * sd[1])));
        double _buf1 = Math.fma(rightData[2], sd[5], Math.fma(rightData[0], sd[1], rightData[1] * sd[3]));
        dd[2] = rightData[2];
        double _buf2 = Math.fma(rightData[5], sd[4], Math.fma(rightData[3], sd[3], -(rightData[4] * sd[1])));
        double _buf3 = Math.fma(rightData[5], sd[5], Math.fma(rightData[3], sd[1], rightData[4] * sd[3]));
        dd[5] = rightData[5];
        double _buf4 = Math.fma(rightData[8], sd[4], Math.fma(rightData[6], sd[3], -(rightData[7] * sd[1])));
        dd[7] = Math.fma(rightData[8], sd[5], Math.fma(rightData[6], sd[1], rightData[7] * sd[3]));
        dd[8] = rightData[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_identity(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_translation(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = rightData[6] + sd[4];
        dd[7] = rightData[7] + sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_identity(Double3x3R right, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_translation(Double3x3R right, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        dd[2] = 0.0;
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        dd[5] = 0.0;
        double _buf4 = Math.fma(rightData[6], sd[0], Math.fma(rightData[7], sd[2], sd[4]));
        dd[7] = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[3], sd[5]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Multiply this matrix by the given matrix and store the result in {@code dest}.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(Double3x3R right, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Double3x3Impl) right).properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_translation_identity(right, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, dest, Joml.BIT_AFFINE & q);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
        return mul_general(right, dest);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_general(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        double _buf2 = Math.fma(otherData[0], sd[2], otherData[2] * sd[3]);
        double _buf3 = Math.fma(otherData[1], sd[2], otherData[3] * sd[3]);
        double _buf4 = Math.fma(otherData[0], sd[4], Math.fma(otherData[2], sd[5], otherData[4]));
        dd[5] = Math.fma(otherData[1], sd[4], Math.fma(otherData[3], sd[5], otherData[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = otherData[0];
        double _buf1 = otherData[1];
        double _buf2 = otherData[2];
        double _buf3 = otherData[3];
        double _buf4 = Math.fma(otherData[0], sd[4], Math.fma(otherData[2], sd[5], otherData[4]));
        dd[5] = Math.fma(otherData[1], sd[4], Math.fma(otherData[3], sd[5], otherData[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_orthogonal(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[3], otherData[2] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[3], otherData[3] * sd[1]);
        double _buf2 = Math.fma(otherData[2], sd[3], -(otherData[0] * sd[1]));
        double _buf3 = Math.fma(otherData[3], sd[3], -(otherData[1] * sd[1]));
        double _buf4 = Math.fma(otherData[0], sd[4], Math.fma(otherData[2], sd[5], otherData[4]));
        dd[5] = Math.fma(otherData[1], sd[4], Math.fma(otherData[3], sd[5], otherData[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_translation_translation(Double2x3R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_orthogonal_translation(Double2x3R other, @Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        ((Double2x3Impl) dest).properties = _props;
        return dest;
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
    public Double2x3 preMul(Double2x3R other, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Double2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
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
    @Mutated public Double2x3 preMul(Double2x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(other);
        int q = ((Double2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
        return preMul_general(other, this);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}) onto this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 preMul(double m00, double m01, double m02, double m10, double m11, double m12, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(m00, sd[0], m01 * sd[1]);
        dd[1] = Math.fma(m10, sd[0], m11 * sd[1]);
        double _buf1 = Math.fma(m00, sd[2], m01 * sd[3]);
        dd[3] = Math.fma(m10, sd[2], m11 * sd[3]);
        double _buf2 = Math.fma(m00, sd[4], Math.fma(m01, sd[5], m02));
        dd[5] = Math.fma(m10, sd[4], Math.fma(m11, sd[5], m12));
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_identity(Double2x2R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = otherData[3];
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_identity_self(Double2x2R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = otherData[3];
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_translation(Double2x2R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = otherData[3];
        double _buf0 = Math.fma(otherData[0], sd[4], otherData[2] * sd[5]);
        dd[5] = Math.fma(otherData[1], sd[4], otherData[3] * sd[5]);
        dd[4] = _buf0;
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_orthogonal(Double2x2R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = Math.fma(otherData[0], sd[3], otherData[2] * sd[1]);
        double _buf0 = Math.fma(otherData[1], sd[3], otherData[3] * sd[1]);
        dd[2] = Math.fma(otherData[2], sd[3], -(otherData[0] * sd[1]));
        dd[3] = Math.fma(otherData[3], sd[3], -(otherData[1] * sd[1]));
        double _buf1 = Math.fma(otherData[0], sd[4], otherData[2] * sd[5]);
        dd[5] = Math.fma(otherData[1], sd[4], otherData[3] * sd[5]);
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double2x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double2x3 preMul_general(Double2x2R other, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[0], sd[2], otherData[2] * sd[3]);
        dd[3] = Math.fma(otherData[1], sd[2], otherData[3] * sd[3]);
        double _buf2 = Math.fma(otherData[0], sd[4], otherData[2] * sd[5]);
        dd[5] = Math.fma(otherData[1], sd[4], otherData[3] * sd[5]);
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preMul(Double2x2R other, @Mutated Double2x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 preMul(Double2x2R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double2x3());
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
    private Double3x3 preMul_general(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[0], otherData[4] * sd[1]);
        double _buf2 = Math.fma(otherData[2], sd[0], otherData[5] * sd[1]);
        double _buf3 = Math.fma(otherData[0], sd[2], otherData[3] * sd[3]);
        double _buf4 = Math.fma(otherData[1], sd[2], otherData[4] * sd[3]);
        double _buf5 = Math.fma(otherData[2], sd[2], otherData[5] * sd[3]);
        double _buf6 = Math.fma(otherData[0], sd[4], Math.fma(otherData[3], sd[5], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[4], Math.fma(otherData[4], sd[5], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[4], Math.fma(otherData[5], sd[5], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = otherData[0];
        double _buf1 = otherData[1];
        double _buf2 = otherData[2];
        double _buf3 = otherData[3];
        double _buf4 = otherData[4];
        double _buf5 = otherData[5];
        double _buf6 = Math.fma(otherData[0], sd[4], Math.fma(otherData[3], sd[5], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[4], Math.fma(otherData[4], sd[5], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[4], Math.fma(otherData[5], sd[5], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[3], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[3], otherData[4] * sd[1]);
        double _buf2 = Math.fma(otherData[2], sd[3], otherData[5] * sd[1]);
        double _buf3 = Math.fma(otherData[3], sd[3], -(otherData[0] * sd[1]));
        double _buf4 = Math.fma(otherData[4], sd[3], -(otherData[1] * sd[1]));
        double _buf5 = Math.fma(otherData[5], sd[3], -(otherData[2] * sd[1]));
        double _buf6 = Math.fma(otherData[0], sd[4], Math.fma(otherData[3], sd[5], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[4], Math.fma(otherData[4], sd[5], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[4], Math.fma(otherData[5], sd[5], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[4];
        dd[7] = otherData[7] + sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_identity(Double3x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0;
        dd[6] = sd[4];
        dd[7] = sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_translation(Double3x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[4];
        dd[7] = otherData[7] + sd[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Pre-multiply the given matrix onto this matrix, i.e. compute {@code other * this} and store
     * the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Double3x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, dest, Joml.BIT_AFFINE & q);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
        return preMul_general(other, dest);
    }


    /**
     * Set this matrix to a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double2x3 makeRotation(double angle) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) this).properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double2x3 makeScaling(Double2R v) {
        return makeScaling(v.x(), v.y());
    }


    /**
     * Set this matrix to a scaling transformation that scales by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double2x3 makeScaling(double vX, double vY) {
        double[] dd = this.data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = vY;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double2x3 makeScaling(double s) {
        double[] dd = this.data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Double2x3 makeTranslation(Double2R v) {
        return makeTranslation(v.x(), v.y());
    }


    /**
     * Set this matrix to a translation transformation that translates by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double2x3 makeTranslation(double vX, double vY) {
        double[] dd = this.data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = vX;
        dd[5] = vY;
        ((Double2x3Impl) this).properties = Joml.BIT_TRANSLATION;
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
    @Mutated public Double2x3 makeView(double left, double right, double bottom, double top) {
        double[] dd = this.data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0 * _t1_inv;
        dd[4] = -((left + right) * _t0_inv);
        dd[5] = -((bottom + top) * _t1_inv);
        ((Double2x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double2x3 preRotate_orthogonal_general(double angle, @Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        double _buf1 = Math.fma(sd[2], _t0, -(sd[3] * _t1));
        dd[3] = Math.fma(sd[2], _t1, sd[3] * _t0);
        double _buf2 = Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0);
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double2x3 preRotate_identity(double angle, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Double2x3 preRotate_identity_self(double angle, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double2x3 preRotate_translation(double angle, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        double _buf0 = Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0);
        dd[4] = _buf0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
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
    public Double2x3 preRotate(double angle, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation(angle, dest);
        return preRotate_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
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
    @Mutated public Double2x3 preRotate(double angle) {
        if (Joml.RETURN_NEW) return preRotate(angle, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation(angle, this);
        return preRotate_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
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
    public Double2x3 preRotateAround(double angle, Double2R pivot, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 preRotateAround(double angle, Double2R pivot) {
        return preRotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double2x3 preRotateAround_identity(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t5 = 2.0 * _t3 * _t3;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        dd[4] = Math.fma(pivotX, _t5, pivotY * _t1);
        dd[5] = Math.fma(pivotY, _t5, -(pivotX * _t1));
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double2x3 preRotateAround_translation(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t5 = 2.0 * _t3 * _t3;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        double _buf0 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        dd[4] = _buf0;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double2x3 preRotateAround_orthogonal(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t5 = 2.0 * _t3 * _t3;
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        double _buf1 = Math.fma(sd[2], _t0, -(sd[3] * _t1));
        dd[3] = Math.fma(sd[2], _t1, sd[3] * _t0);
        double _buf2 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double2x3 preRotateAround_general(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t5 = 2.0 * _t3 * _t3;
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        double _buf1 = Math.fma(sd[2], _t0, -(sd[3] * _t1));
        dd[3] = Math.fma(sd[2], _t1, sd[3] * _t0);
        double _buf2 = Math.fma(pivotX, _t5, pivotY * _t1) + Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0) + Math.fma(pivotY, _t5, -(pivotX * _t1));
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preRotateAround(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(angle, pivotX, pivotY, dest);
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
    @Mutated public Double2x3 preRotateAround(double angle, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preRotateAround(angle, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(angle, pivotX, pivotY, this);
        return preRotateAround_general(angle, pivotX, pivotY, this);
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
    public Double2x3 preScale(Double2R v, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 preScale(Double2R v) {
        return preScale(v.x(), v.y());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_identity(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = vY;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_identity_self(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[3] = vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_translation(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = vY;
        dd[4] = sd[4] * vX;
        dd[5] = sd[5] * vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_translation_self(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[3] = vY;
        dd[4] = sd[4] * vX;
        dd[5] = sd[5] * vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_general(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[2] = sd[2] * vX;
        dd[3] = sd[3] * vY;
        dd[4] = sd[4] * vX;
        dd[5] = sd[5] * vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preScale(double vX, double vY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY, dest);
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
    @Mutated public Double2x3 preScale(double vX, double vY) {
        if (Joml.RETURN_NEW) return preScale(vX, vY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(vX, vY, this);
        return preScale_general(vX, vY, this);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_identity(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_identity_self(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_translation(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = s * sd[4];
        dd[5] = s * sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_translation_self(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        dd[4] = s * sd[4];
        dd[5] = s * sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double2x3 preScale_general(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = s * sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preScale(double s, @Mutated Double2x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 preScale(double s) {
        if (Joml.RETURN_NEW) return preScale(s, Joml.double2x3());
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
    public Double2x3 preScaleAround(double s, Double2R pivot, @Mutated Double2x3 dest) {
        return preScaleAround(s, pivot.x(), pivot.y(), dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Double2x3 preScaleAround(double s, Double2R pivot) {
        return preScaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_identity(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, pivotX);
        dd[5] = Math.fma(-s, pivotY, pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_identity_self(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, pivotX);
        dd[5] = Math.fma(-s, pivotY, pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_translation(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, Math.fma(s, sd[4], pivotX));
        dd[5] = Math.fma(-s, pivotY, Math.fma(s, sd[5], pivotY));
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_translation_self(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, Math.fma(s, sd[4], pivotX));
        dd[5] = Math.fma(-s, pivotY, Math.fma(s, sd[5], pivotY));
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_general(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        dd[4] = Math.fma(-s, pivotX, Math.fma(s, sd[4], pivotX));
        dd[5] = Math.fma(-s, pivotY, Math.fma(s, sd[5], pivotY));
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY})
     * onto this matrix and store the result in {@code dest}.
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
    public Double2x3 preScaleAround(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY, dest);
        return preScaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY})
     * onto this matrix.
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
    @Mutated public Double2x3 preScaleAround(double s, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(s, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(s, pivotX, pivotY, this);
        return preScaleAround_general(s, pivotX, pivotY, this);
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
    public Double2x3 preScaleAround(Double2R s, Double2R pivot, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 preScaleAround(Double2R s, Double2R pivot) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_identity(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = sY;
        dd[4] = Math.fma(-pivotX, sX, pivotX);
        dd[5] = Math.fma(-pivotY, sY, pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_identity_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sX;
        dd[3] = sY;
        dd[4] = Math.fma(-pivotX, sX, pivotX);
        dd[5] = Math.fma(-pivotY, sY, pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double2x3 preScaleAround_general(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sX * sd[0];
        dd[1] = sY * sd[1];
        dd[2] = sX * sd[2];
        dd[3] = sY * sd[3];
        dd[4] = Math.fma(-pivotX, sX, Math.fma(sX, sd[4], pivotX));
        dd[5] = Math.fma(-pivotY, sY, Math.fma(sY, sd[5], pivotY));
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preScaleAround(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
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
    @Mutated public Double2x3 preScaleAround(double sX, double sY, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(sX, sY, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        return preScaleAround_general(sX, sY, pivotX, pivotY, this);
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
    public Double2x3 preTranslate(Double2R v, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 preTranslate(Double2R v) {
        return preTranslate(v.x(), v.y());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_identity(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = vX;
        dd[5] = vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_identity_self(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[4] = vX;
        dd[5] = vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_translation(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = sd[4] + vX;
        dd[5] = sd[5] + vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_translation_self(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[4] = sd[4] + vX;
        dd[5] = sd[5] + vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_orthogonal(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4] + vX;
        dd[5] = sd[5] + vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double2x3 preTranslate_general(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4] + vX;
        dd[5] = sd[5] + vY;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 preTranslate(double vX, double vY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY, dest);
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
    @Mutated public Double2x3 preTranslate(double vX, double vY) {
        if (Joml.RETURN_NEW) return preTranslate(vX, vY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY, this);
        return preTranslate_general(vX, vY, this);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double2x3 rotate_orthogonal_general(double angle, @Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[3] * _t1);
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[3] = Math.fma(sd[3], _t0, -(sd[1] * _t1));
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double2x3 rotate_identity(double angle, @Mutated Double2x3 dest) {
        return preRotate_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Double2x3 rotate_identity_self(double angle, @Mutated Double2x3 dest) {
        return preRotate_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double2x3 rotate_translation(double angle, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
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
    public Double2x3 rotate(double angle, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation(angle, dest);
        return rotate_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
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
    @Mutated public Double2x3 rotate(double angle) {
        if (Joml.RETURN_NEW) return rotate(angle, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation(angle, this);
        return rotate_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
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
    public Double2x3 rotateAround(double angle, Double2R pivot, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 rotateAround(double angle, Double2R pivot) {
        return rotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double2x3 rotateAround_identity(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return preRotateAround_identity(angle, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double2x3 rotateAround_translation(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t5 = 2.0 * _t3 * _t3;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        dd[4] = Math.fma(pivotX, _t5, Math.fma(pivotY, _t1, sd[4]));
        dd[5] = Math.fma(pivotY, _t5, Math.fma(-pivotX, _t1, sd[5]));
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double2x3 rotateAround_orthogonal(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        double _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        double _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[3] * _t1);
        double _buf2 = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        double _buf3 = Math.fma(sd[3], _t0, -(sd[1] * _t1));
        dd[4] = Math.fma(sd[0], _t9, Math.fma(sd[2], _t10, sd[4]));
        dd[5] = Math.fma(sd[1], _t9, Math.fma(sd[3], _t10, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double2x3 rotateAround_general(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        double _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        double _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[3] * _t1);
        double _buf2 = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        double _buf3 = Math.fma(sd[3], _t0, -(sd[1] * _t1));
        dd[4] = Math.fma(sd[0], _t9, Math.fma(sd[2], _t10, sd[4]));
        dd[5] = Math.fma(sd[1], _t9, Math.fma(sd[3], _t10, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 rotateAround(double angle, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(angle, pivotX, pivotY, dest);
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
    @Mutated public Double2x3 rotateAround(double angle, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return rotateAround(angle, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(angle, pivotX, pivotY, this);
        return rotateAround_general(angle, pivotX, pivotY, this);
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
    public Double2x3 scale(Double2R v, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 scale(Double2R v) {
        return scale(v.x(), v.y());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_identity(double vX, double vY, @Mutated Double2x3 dest) {
        return preScale_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double2x3 scale_identity_self(double vX, double vY, @Mutated Double2x3 dest) {
        return preScale_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_translation(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = vY;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double2x3 scale_translation_self(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = vX;
        dd[3] = vY;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_general(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[2] = sd[2] * vY;
        dd[3] = sd[3] * vY;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 scale(double vX, double vY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY, dest);
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
    @Mutated public Double2x3 scale(double vX, double vY) {
        if (Joml.RETURN_NEW) return scale(vX, vY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(vX, vY, this);
        return scale_general(vX, vY, this);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_identity(double s, @Mutated Double2x3 dest) {
        return preScale_identity(s, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double2x3 scale_identity_self(double s, @Mutated Double2x3 dest) {
        return preScale_identity_self(s, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_translation(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double2x3 scale_translation_self(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double2x3 scale_general(double s, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 scale(double s, @Mutated Double2x3 dest) {
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated public Double2x3 scale(double s) {
        if (Joml.RETURN_NEW) return scale(s, Joml.double2x3());
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
    public Double2x3 scaleAround(double s, Double2R pivot, @Mutated Double2x3 dest) {
        return scaleAround(s, pivot.x(), pivot.y(), dest);
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
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    public @Mutated Double2x3 scaleAround(double s, Double2R pivot) {
        return scaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_identity(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return preScaleAround_identity(s, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_identity_self(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return preScaleAround_identity_self(s, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_translation(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, sd[4] + pivotX);
        dd[5] = Math.fma(-s, pivotY, sd[5] + pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_translation_self(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        dd[4] = Math.fma(-s, pivotX, sd[4] + pivotX);
        dd[5] = Math.fma(-s, pivotY, sd[5] + pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_orthogonal(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _buf0 = s * sd[0];
        double _buf1 = s * sd[1];
        double _buf2 = s * sd[2];
        double _buf3 = s * sd[3];
        dd[4] = Math.fma(sd[0], _t0, Math.fma(sd[2], _t1, sd[4]));
        dd[5] = Math.fma(sd[1], _t0, Math.fma(sd[3], _t1, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_general(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return scaleAround_orthogonal(s, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY}) to this
     * matrix and store the result in {@code dest}.
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
    public Double2x3 scaleAround(double s, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(s, pivotX, pivotY, dest);
        return scaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY}) to this
     * matrix.
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
    @Mutated public Double2x3 scaleAround(double s, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(s, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(s, pivotX, pivotY, this);
        return scaleAround_general(s, pivotX, pivotY, this);
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
    public Double2x3 scaleAround(Double2R s, Double2R pivot, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 scaleAround(Double2R s, Double2R pivot) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_identity(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_identity_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return preScaleAround_identity_self(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_translation(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = sY;
        dd[4] = Math.fma(-pivotX, sX, sd[4] + pivotX);
        dd[5] = Math.fma(-pivotY, sY, sd[5] + pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_translation_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sX;
        dd[3] = sY;
        dd[4] = Math.fma(-pivotX, sX, sd[4] + pivotX);
        dd[5] = Math.fma(-pivotY, sY, sd[5] + pivotY);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_orthogonal(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        double _buf0 = sX * sd[0];
        double _buf1 = sX * sd[1];
        double _buf2 = sY * sd[2];
        double _buf3 = sY * sd[3];
        dd[4] = Math.fma(sd[0], _t2, Math.fma(sd[2], _t3, sd[4]));
        dd[5] = Math.fma(sd[1], _t2, Math.fma(sd[3], _t3, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double2x3 scaleAround_general(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        return scaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
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
    public Double2x3 scaleAround(double sX, double sY, double pivotX, double pivotY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
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
    @Mutated public Double2x3 scaleAround(double sX, double sY, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(sX, sY, pivotX, pivotY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(sX, sY, pivotX, pivotY, this);
        return scaleAround_general(sX, sY, pivotX, pivotY, this);
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
    public Double2x3 translate(Double2R v, @Mutated Double2x3 dest) {
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
    public @Mutated Double2x3 translate(Double2R v) {
        return translate(v.x(), v.y());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_identity(double vX, double vY, @Mutated Double2x3 dest) {
        return preTranslate_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_identity_self(double vX, double vY, @Mutated Double2x3 dest) {
        return preTranslate_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_translation(double vX, double vY, @Mutated Double2x3 dest) {
        return preTranslate_translation(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_translation_self(double vX, double vY, @Mutated Double2x3 dest) {
        return preTranslate_translation_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_orthogonal(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        dd[4] = Math.fma(sd[0], vX, Math.fma(sd[2], vY, sd[4]));
        dd[5] = Math.fma(sd[1], vX, Math.fma(sd[3], vY, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double2x3 translate_general(double vX, double vY, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        dd[4] = Math.fma(sd[0], vX, Math.fma(sd[2], vY, sd[4]));
        dd[5] = Math.fma(sd[1], vX, Math.fma(sd[3], vY, sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 translate(double vX, double vY, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY, dest);
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
    @Mutated public Double2x3 translate(double vX, double vY) {
        if (Joml.RETURN_NEW) return translate(vX, vY, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY, this);
        return translate_general(vX, vY, this);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double2x3 view_identity(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0 * _t1_inv;
        dd[4] = -((left + right) * _t0_inv);
        dd[5] = -((bottom + top) * _t1_inv);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double2x3 view_identity_self(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[3] = 2.0 * _t1_inv;
        dd[4] = -((left + right) * _t0_inv);
        dd[5] = -((bottom + top) * _t1_inv);
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double2x3 view_translation(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 2.0 * _t1_inv;
        dd[4] = sd[4] - (left + right) * _t0_inv;
        dd[5] = sd[5] - (bottom + top) * _t1_inv;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double2x3 view_translation_self(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[3] = 2.0 * _t1_inv;
        dd[4] = sd[4] - (left + right) * _t0_inv;
        dd[5] = sd[5] - (bottom + top) * _t1_inv;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double2x3 view_orthogonal(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        double _buf2 = 2.0 * sd[2] * _t1_inv;
        double _buf3 = 2.0 * sd[3] * _t1_inv;
        dd[4] = sd[4] - sd[0] * _t2 * _t0_inv - sd[2] * _t3 * _t1_inv;
        dd[5] = sd[5] - sd[1] * _t2 * _t0_inv - sd[3] * _t3 * _t1_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double2x3 view_general(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        double _buf2 = 2.0 * sd[2] * _t1_inv;
        double _buf3 = 2.0 * sd[3] * _t1_inv;
        dd[4] = sd[4] + (-(sd[0] * _t2 * _t0_inv) - sd[2] * _t3 * _t1_inv);
        dd[5] = sd[5] + (-(sd[1] * _t2 * _t0_inv) - sd[3] * _t3 * _t1_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
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
    public Double2x3 view(double left, double right, double bottom, double top, @Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity(left, right, bottom, top, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation(left, right, bottom, top, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal(left, right, bottom, top, dest);
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
    @Mutated public Double2x3 view(double left, double right, double bottom, double top) {
        if (Joml.RETURN_NEW) return view(left, right, bottom, top, Joml.double2x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal(left, right, bottom, top, this);
        return view_general(left, right, bottom, top, this);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 mul(Double3R v, @Mutated Double2 dest) {
        return mul(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2 mul_identity(double vX, double vY, double vZ, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = vX;
        dd[1] = vY;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2 mul_translation(double vX, double vY, double vZ, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.fma(sd[4], vZ, vX);
        dd[1] = Math.fma(sd[5], vZ, vY);
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double2 mul_general(double vX, double vY, double vZ, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.fma(sd[4], vZ, Math.fma(sd[0], vX, sd[2] * vY));
        dd[1] = Math.fma(sd[5], vZ, Math.fma(sd[1], vX, sd[3] * vY));
        return dest;
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
    public Double2 mul(double vX, double vY, double vZ, @Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ, dest);
        return mul_general(vX, vY, vZ, dest);
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 transformDirection(Double2R v, @Mutated Double2 dest) {
        return transformDirection(v.x(), v.y(), dest);
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Double2 transformDirection_identity(double vX, double vY, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = vX;
        dd[1] = vY;
        return dest;
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Double2 transformDirection_general(double vX, double vY, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.fma(sd[0], vX, sd[2] * vY);
        dd[1] = Math.fma(sd[1], vX, sd[3] * vY);
        return dest;
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 transformDirection(double vX, double vY, @Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformDirection_identity(vX, vY, dest);
        return transformDirection_general(vX, vY, dest);
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double2 transformPosition(Double2R v, @Mutated Double2 dest) {
        return transformPosition(v.x(), v.y(), dest);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double2 transformPosition_identity(double vX, double vY, @Mutated Double2 dest) {
        return transformDirection_identity(vX, vY, dest);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double2 transformPosition_translation(double vX, double vY, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[4] + vX;
        dd[1] = sd[5] + vY;
        return dest;
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double2 transformPosition_general(double vX, double vY, @Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.fma(sd[0], vX, Math.fma(sd[2], vY, sd[4]));
        dd[1] = Math.fma(sd[1], vX, Math.fma(sd[3], vY, sd[5]));
        return dest;
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 transformPosition(double vX, double vY, @Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transformPosition_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformPosition_translation(vX, vY, dest);
        return transformPosition_general(vX, vY, dest);
    }

    public double m00() { return data[0]; }
    public double m01() { return data[2]; }
    public double m02() { return data[4]; }
    public double m10() { return data[1]; }
    public double m11() { return data[3]; }
    public double m12() { return data[5]; }

    @Override public String toString() {
        return "Double2x3(\n    " + m00() + ", " + m01() + ", " + m02() + "\n    " + m10() + ", " + m11() + ", " + m12() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double2x3Impl)) return false;
        Double2x3Impl o = (Double2x3Impl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Double.isFinite(data[0])
            && Double.isFinite(data[1])
            && Double.isFinite(data[2])
            && Double.isFinite(data[3])
            && Double.isFinite(data[4])
            && Double.isFinite(data[5]);
    }

    @Override public boolean equalsEpsilon(Double2x3R other, double epsilon) {
        return Math.abs(data[0] - other.m00()) <= epsilon
            && Math.abs(data[2] - other.m01()) <= epsilon
            && Math.abs(data[4] - other.m02()) <= epsilon
            && Math.abs(data[1] - other.m10()) <= epsilon
            && Math.abs(data[3] - other.m11()) <= epsilon
            && Math.abs(data[5] - other.m12()) <= epsilon;
    }

    public double[] storeCM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadCM(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double2x3 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Double2x3 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Double2x3 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Double2x3 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) this.data[3];
        dest[offset + 4] = (float) this.data[4];
        dest[offset + 5] = (float) this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadCM(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double2x3 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf);
    }
    public Double2x3 loadCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf);
    }
    public Double2x3 storeCMFloatUnsafe(long address) {
        return RAW_OPS.storeCMFloatUnsafe(this, address);
    }
    @Mutated public Double2x3 loadCMFloatUnsafe(long address) {
        return RAW_OPS.loadCMFloatUnsafe(this, address);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        if (dest == this.data) return storeRM_aliased(dest, offset);
        return storeRM_distinct(dest, offset);
    }
    private double[] storeRM_distinct(double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = this.data[4];
        dest[offset + 3] = this.data[1];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = this.data[5];
        return dest;
    }
    private double[] storeRM_aliased(double[] dest, int offset) {
        double[] d = this.data;
        double t0 = d[0];
        double t1 = d[1];
        double t2 = d[2];
        double t3 = d[3];
        double t4 = d[4];
        double t5 = d[5];
        dest[offset + 0] = t0;
        dest[offset + 1] = t2;
        dest[offset + 2] = t4;
        dest[offset + 3] = t1;
        dest[offset + 4] = t3;
        dest[offset + 5] = t5;
        return dest;
    }
    @Mutated public Double2x3 loadRM(double[] src, int offset) {
        if (src == this.data) return loadRM_aliased(src, offset);
        return loadRM_distinct(src, offset);
    }
    private Double2x3 loadRM_distinct(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[2] = src[offset + 1];
        this.data[4] = src[offset + 2];
        this.data[1] = src[offset + 3];
        this.data[3] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.properties = determineProperties();
        return this;
    }
    private Double2x3 loadRM_aliased(double[] src, int offset) {
        double t0 = src[offset + 0];
        double t1 = src[offset + 1];
        double t2 = src[offset + 2];
        double t3 = src[offset + 3];
        double t4 = src[offset + 4];
        double t5 = src[offset + 5];
        double[] d = this.data;
        d[0] = t0;
        d[2] = t1;
        d[4] = t2;
        d[1] = t3;
        d[3] = t4;
        d[5] = t5;
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double2x3 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Double2x3 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Double2x3 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Double2x3 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[2];
        dest[offset + 2] = (float) this.data[4];
        dest[offset + 3] = (float) this.data[1];
        dest[offset + 4] = (float) this.data[3];
        dest[offset + 5] = (float) this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadRM(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[2] = src[offset + 1];
        this.data[4] = src[offset + 2];
        this.data[1] = src[offset + 3];
        this.data[3] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double2x3 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf);
    }
    public Double2x3 loadRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf);
    }
    public Double2x3 storeRMFloatUnsafe(long address) {
        return RAW_OPS.storeRMFloatUnsafe(this, address);
    }
    @Mutated public Double2x3 loadRMFloatUnsafe(long address) {
        return RAW_OPS.loadRMFloatUnsafe(this, address);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[_p1] = this.data[2];
        dest[_p1 + 1] = this.data[3];
        dest[_p2] = this.data[4];
        dest[_p2 + 1] = this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[1] = src[offset + 1];
        this.data[2] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.data[4] = src[_p2];
        this.data[5] = src[_p2 + 1];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double2x3 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Double2x3 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Double2x3 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Double2x3 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[_p1] = (float) this.data[2];
        dest[_p1 + 1] = (float) this.data[3];
        dest[_p2] = (float) this.data[4];
        dest[_p2 + 1] = (float) this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[1] = src[offset + 1];
        this.data[2] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.data[4] = src[_p2];
        this.data[5] = src[_p2 + 1];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double2x3 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf, stride);
    }
    public Double2x3 loadCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf, stride);
    }
    public Double2x3 storeCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeCMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double2x3 loadCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadCMFloatUnsafe(this, address, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        if (dest == this.data) return storeRM_aliased(dest, offset, stride);
        return storeRM_distinct(dest, offset, stride);
    }
    private double[] storeRM_distinct(double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = this.data[4];
        dest[_p1] = this.data[1];
        dest[_p1 + 1] = this.data[3];
        dest[_p1 + 2] = this.data[5];
        return dest;
    }
    private double[] storeRM_aliased(double[] dest, int offset, int stride) {
        double[] d = this.data;
        double t0 = d[0];
        double t1 = d[1];
        double t2 = d[2];
        double t3 = d[3];
        double t4 = d[4];
        double t5 = d[5];
        int _p1 = offset + stride;
        dest[offset] = t0;
        dest[offset + 1] = t2;
        dest[offset + 2] = t4;
        dest[_p1] = t1;
        dest[_p1 + 1] = t3;
        dest[_p1 + 2] = t5;
        return dest;
    }
    @Mutated public Double2x3 loadRM(double[] src, int offset, int stride) {
        if (src == this.data) return loadRM_aliased(src, offset, stride);
        return loadRM_distinct(src, offset, stride);
    }
    private Double2x3 loadRM_distinct(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = src[offset];
        this.data[2] = src[offset + 1];
        this.data[4] = src[offset + 2];
        this.data[1] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.data[5] = src[_p1 + 2];
        this.properties = determineProperties();
        return this;
    }
    private Double2x3 loadRM_aliased(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        double t0 = src[offset];
        double t1 = src[offset + 1];
        double t2 = src[offset + 2];
        double t3 = src[_p1];
        double t4 = src[_p1 + 1];
        double t5 = src[_p1 + 2];
        double[] d = this.data;
        d[0] = t0;
        d[2] = t1;
        d[4] = t2;
        d[1] = t3;
        d[3] = t4;
        d[5] = t5;
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double2x3 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Double2x3 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Double2x3 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Double2x3 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[2];
        dest[offset + 2] = (float) this.data[4];
        dest[_p1] = (float) this.data[1];
        dest[_p1 + 1] = (float) this.data[3];
        dest[_p1 + 2] = (float) this.data[5];
        return dest;
    }
    public @Mutated Double2x3 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = src[offset];
        this.data[2] = src[offset + 1];
        this.data[4] = src[offset + 2];
        this.data[1] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.data[5] = src[_p1 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double2x3 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf, stride);
    }
    public Double2x3 loadRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf, stride);
    }
    public Double2x3 storeRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeRMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double2x3 loadRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadRMFloatUnsafe(this, address, stride);
    }

    public double[] storeCM3x3(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0;
        dest[offset + 3] = this.data[2];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = 0.0;
        dest[offset + 6] = this.data[4];
        dest[offset + 7] = this.data[5];
        dest[offset + 8] = 1.0;
        return dest;
    }
    public DoubleBuffer storeCM3x3Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeCM3x3Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public Double2x3 storeCM3x3Unsafe(long address) {
        return RAW_OPS.storeCM3x3Unsafe(this, address);
    }

    public float[] storeCM3x3(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) 0.0;
        dest[offset + 3] = (float) this.data[2];
        dest[offset + 4] = (float) this.data[3];
        dest[offset + 5] = (float) 0.0;
        dest[offset + 6] = (float) this.data[4];
        dest[offset + 7] = (float) this.data[5];
        dest[offset + 8] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeCM3x3Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeCM3x3FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM3x3FloatAbsolute(this, index, buf);
    }
    public Double2x3 storeCM3x3FloatUnsafe(long address) {
        return RAW_OPS.storeCM3x3FloatUnsafe(this, address);
    }

    public double[] storeRM3x3(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = this.data[4];
        dest[offset + 3] = this.data[1];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = 0.0;
        dest[offset + 7] = 0.0;
        dest[offset + 8] = 1.0;
        return dest;
    }
    public DoubleBuffer storeRM3x3Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeRM3x3Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public Double2x3 storeRM3x3Unsafe(long address) {
        return RAW_OPS.storeRM3x3Unsafe(this, address);
    }

    public float[] storeRM3x3(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[2];
        dest[offset + 2] = (float) this.data[4];
        dest[offset + 3] = (float) this.data[1];
        dest[offset + 4] = (float) this.data[3];
        dest[offset + 5] = (float) this.data[5];
        dest[offset + 6] = (float) 0.0;
        dest[offset + 7] = (float) 0.0;
        dest[offset + 8] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeRM3x3Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeRM3x3FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM3x3FloatAbsolute(this, index, buf);
    }
    public Double2x3 storeRM3x3FloatUnsafe(long address) {
        return RAW_OPS.storeRM3x3FloatUnsafe(this, address);
    }

    public double[] storeCM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0;
        dest[offset + 3] = 0.0;
        dest[offset + 4] = this.data[2];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0;
        dest[offset + 7] = 0.0;
        dest[offset + 8] = 0.0;
        dest[offset + 9] = 0.0;
        dest[offset + 10] = 1.0;
        dest[offset + 11] = 0.0;
        dest[offset + 12] = this.data[4];
        dest[offset + 13] = this.data[5];
        dest[offset + 14] = 0.0;
        dest[offset + 15] = 1.0;
        return dest;
    }
    public DoubleBuffer storeCM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public Double2x3 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }

    public float[] storeCM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) 0.0;
        dest[offset + 3] = (float) 0.0;
        dest[offset + 4] = (float) this.data[2];
        dest[offset + 5] = (float) this.data[3];
        dest[offset + 6] = (float) 0.0;
        dest[offset + 7] = (float) 0.0;
        dest[offset + 8] = (float) 0.0;
        dest[offset + 9] = (float) 0.0;
        dest[offset + 10] = (float) 1.0;
        dest[offset + 11] = (float) 0.0;
        dest[offset + 12] = (float) this.data[4];
        dest[offset + 13] = (float) this.data[5];
        dest[offset + 14] = (float) 0.0;
        dest[offset + 15] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeCM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4FloatAbsolute(this, index, buf);
    }
    public Double2x3 storeCM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeCM4x4FloatUnsafe(this, address);
    }

    public double[] storeRM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = 0.0;
        dest[offset + 3] = this.data[4];
        dest[offset + 4] = this.data[1];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0;
        dest[offset + 7] = this.data[5];
        dest[offset + 8] = 0.0;
        dest[offset + 9] = 0.0;
        dest[offset + 10] = 1.0;
        dest[offset + 11] = 0.0;
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
    public Double2x3 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }

    public float[] storeRM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[2];
        dest[offset + 2] = (float) 0.0;
        dest[offset + 3] = (float) this.data[4];
        dest[offset + 4] = (float) this.data[1];
        dest[offset + 5] = (float) this.data[3];
        dest[offset + 6] = (float) 0.0;
        dest[offset + 7] = (float) this.data[5];
        dest[offset + 8] = (float) 0.0;
        dest[offset + 9] = (float) 0.0;
        dest[offset + 10] = (float) 1.0;
        dest[offset + 11] = (float) 0.0;
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
    public Double2x3 storeRM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeRM4x4FloatUnsafe(this, address);
    }

}
