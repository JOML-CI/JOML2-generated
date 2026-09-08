package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link Float2x2} backed by a {@code float[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Float2x2Impl implements Float2x2 {

    public float[] data;
    public int properties;
    static final Float2x2SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float2x2SegOpsUnsafe()
                    : new Float2x2SegOpsMS();
    static final Float2x2BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float2x2BbOpsUnsafe()
                    : new Float2x2BbOpsApi();
    static final Float2x2RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float2x2RawOpsUnsafe()
                    : new Float2x2RawOpsApi();

    public Float2x2Impl() {
        data = new float[4];
        data[0] = 1;
        data[3] = 1;
        properties = Joml.BIT_IDENTITY;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits. This is a pure query.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.data[1] != 0 || this.data[3] != 1) return 0;
        if (this.data[0] != 1) return 1;
        if (this.data[2] != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    @Override public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    @Override public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal} O(1) read of the cached property bits; conservative. */
    @Override public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is known to be affine} O(1) read of the cached property bits; conservative. */
    @Override public boolean isAffine() { return (this.properties & Joml.BIT_AFFINE) == Joml.BIT_AFFINE; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float2 getColumn_identity(int col, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw0;
        float _idxSw1;
        switch (col) {
            case 0: _idxSw0 = 1.0f; _idxSw1 = 0.0f; break;
            case 1: _idxSw0 = 0.0f; _idxSw1 = 1.0f; break;
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
    private Float2 getColumn_translation(int col, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw2;
        float _idxSw3;
        switch (col) {
            case 0: _idxSw2 = 1.0f; _idxSw3 = 0.0f; break;
            case 1: _idxSw2 = sd[2]; _idxSw3 = 1.0f; break;
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
    private Float2 getColumn_affine(int col, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw4;
        float _idxSw5;
        switch (col) {
            case 0: _idxSw4 = sd[0]; _idxSw5 = 0.0f; break;
            case 1: _idxSw4 = sd[2]; _idxSw5 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw4;
        dd[1] = _idxSw5;
        return dest;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float2 getColumn_general(int col, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw6;
        float _idxSw7;
        switch (col) {
            case 0: _idxSw6 = sd[0]; _idxSw7 = sd[1]; break;
            case 1: _idxSw6 = sd[2]; _idxSw7 = sd[3]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw6;
        dd[1] = _idxSw7;
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
    public Float2 getColumn(int col, @Mutated Float2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return getColumn_translation(col, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getColumn_affine(col, dest);
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
    public Double2 getColumn(int col, @Mutated Double2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        float _idxSw8;
        float _idxSw9;
        switch (col) {
            case 0: _idxSw8 = sd[0]; _idxSw9 = sd[1]; break;
            case 1: _idxSw8 = sd[2]; _idxSw9 = sd[3]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw8;
        dd[1] = _idxSw9;
        return dest;
    }


    /**
     * Compute the rotation angle in radians ({@code atan2(m10, m00)}) of this matrix; for a matrix
     * carrying scale the rotation angle is still recovered as long as the X-axis scale is positive.
     *
     * @return the rotation angle in radians ({@code atan2(m10, m00)}) of this matrix; for a matrix
     *        carrying scale the rotation angle is still recovered as long as the X-axis scale is
     *        positive
     */
    public float getRotationAngle() {
        float[] sd = this.data;
        return (float) Math.atan2(sd[1], sd[0]);
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float2 getRow_identity(int row, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw0;
        float _idxSw1;
        switch (row) {
            case 0: _idxSw0 = 1.0f; _idxSw1 = 0.0f; break;
            case 1: _idxSw0 = 0.0f; _idxSw1 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw0;
        dd[1] = _idxSw1;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float2 getRow_translation(int row, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw2;
        float _idxSw3;
        switch (row) {
            case 0: _idxSw2 = 1.0f; _idxSw3 = sd[2]; break;
            case 1: _idxSw2 = 0.0f; _idxSw3 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw2;
        dd[1] = _idxSw3;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float2 getRow_affine(int row, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw4;
        float _idxSw5;
        switch (row) {
            case 0: _idxSw4 = sd[0]; _idxSw5 = sd[2]; break;
            case 1: _idxSw4 = 0.0f; _idxSw5 = 1.0f; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw4;
        dd[1] = _idxSw5;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float2 getRow_general(int row, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _idxSw6;
        float _idxSw7;
        switch (row) {
            case 0: _idxSw6 = sd[0]; _idxSw7 = sd[2]; break;
            case 1: _idxSw6 = sd[1]; _idxSw7 = sd[3]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw6;
        dd[1] = _idxSw7;
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
    public Float2 getRow(int row, @Mutated Float2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return getRow_translation(row, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getRow_affine(row, dest);
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
    public Double2 getRow(int row, @Mutated Double2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        float _idxSw8;
        float _idxSw9;
        switch (row) {
            case 0: _idxSw8 = sd[0]; _idxSw9 = sd[2]; break;
            case 1: _idxSw8 = sd[1]; _idxSw9 = sd[3]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw8;
        dd[1] = _idxSw9;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_identity(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_identity_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        ((Float2x2Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_translation(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = -sd[2];
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_translation_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[1] = -sd[2];
        dd[2] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_affine(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = 1.0f;
        dd[1] = -sd[2];
        dd[2] = 0.0f;
        dd[3] = sd[0];
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float2x2 cofactor_general(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = sd[3];
        float _buf1 = -sd[2];
        dd[2] = -sd[1];
        dd[3] = sd[0];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 cofactor(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine(dest);
        return cofactor_general(dest);
    }


    /**
     * Compute the cofactor matrix of this matrix.
     *
     * @return this
     */
    @Mutated public Float2x2 cofactor() {
        if (Joml.RETURN_NEW) return cofactor(Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_translation_self(this);
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
    public Double2x2 cofactor(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _buf0 = sd[3];
        float _buf1 = -sd[2];
        dd[2] = -sd[1];
        dd[3] = sd[0];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    public float determinant() {
        float[] sd = this.data;
        return Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public float frobeniusNorm() {
        float[] sd = this.data;
        return (float) Math.sqrt(Math.fma(sd[3], sd[3], Math.fma(sd[1], sd[1], Math.fma(sd[0], sd[0], sd[2] * sd[2]))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_identity(@Mutated Float2x2 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_identity_self(@Mutated Float2x2 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_translation(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = -sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_translation_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[2] = -sd[2];
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_affine(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = 0.0f;
        dd[2] = -(sd[2] * _rcp0);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_affine_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        dd[0] = 1.0f * _rcp0;
        dd[2] = -(sd[2] * _rcp0);
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float2x2 invert_general(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = sd[3] * _t2_inv;
        dd[1] = -(sd[1] * _t2_inv);
        dd[2] = -(sd[2] * _t2_inv);
        dd[3] = sd[0] * _t2_inv;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Invert this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 invert(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine(dest);
        return invert_general(dest);
    }


    /**
     * Invert this matrix.
     *
     * @return this
     */
    @Mutated public Float2x2 invert() {
        if (Joml.RETURN_NEW) return invert(Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_translation_self(this);
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
    public Double2x2 invert(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = sd[3] * _t2_inv;
        dd[1] = -(sd[1] * _t2_inv);
        dd[2] = -(sd[2] * _t2_inv);
        dd[3] = sd[0] * _t2_inv;
        dd[0] = _buf0;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_general(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t4 = Math.fma(otherData[2], sd[1], otherData[3] * sd[3]);
        float _t5 = Math.fma(otherData[0], sd[0], otherData[1] * sd[2]);
        float _t6 = Math.fma(otherData[0], sd[1], otherData[1] * sd[3]);
        float _t7 = Math.fma(otherData[2], sd[0], otherData[3] * sd[2]);
        float _t10 = Math.fma(_t5, _t4, -(_t6 * _t7));
        float _t10_inv = 1.0f / _t10;
        dd[0] = _t4 * _t10_inv;
        dd[1] = -(_t6 * _t10_inv);
        dd[2] = -(_t7 * _t10_inv);
        dd[3] = _t5 * _t10_inv;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t2 = Math.fma(otherData[0], otherData[3], -(otherData[2] * otherData[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = otherData[3] * _t2_inv;
        dd[1] = -(otherData[1] * _t2_inv);
        dd[2] = -(otherData[2] * _t2_inv);
        dd[3] = otherData[0] * _t2_inv;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = Math.fma(otherData[1], sd[2], otherData[0]);
        float _t1 = Math.fma(otherData[3], sd[2], otherData[2]);
        float _t4 = Math.fma(otherData[3], _t0, -(otherData[1] * _t1));
        float _t4_inv = 1.0f / _t4;
        dd[0] = otherData[3] * _t4_inv;
        dd[1] = -(otherData[1] * _t4_inv);
        dd[2] = -(_t1 * _t4_inv);
        dd[3] = _t0 * _t4_inv;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_orthogonal(Float2x2R other, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t2 = Math.fma(otherData[0], sd[0], otherData[1] * sd[2]);
        float _t3 = Math.fma(otherData[2], sd[0], otherData[3] * sd[2]);
        float _t6 = Math.fma(otherData[3], _t2, -(otherData[1] * _t3));
        float _t6_inv = 1.0f / _t6;
        dd[0] = otherData[3] * _t6_inv;
        dd[1] = -(otherData[1] * _t6_inv);
        dd[2] = -(_t3 * _t6_inv);
        dd[3] = _t2 * _t6_inv;
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_identity_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_identity_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = -otherData[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_identity_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / otherData[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = 0.0f;
        dd[2] = -(otherData[2] * _rcp0);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_translation_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = -sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_translation_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = -(otherData[2] + sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_translation_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / otherData[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = 0.0f;
        dd[2] = -((otherData[2] + sd[2]) * _rcp0);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_orthogonal_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = -otherData[2] - sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_orthogonal_affine(Float2x2R other, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = otherData[0] * sd[0];
        float _t0_inv = 1.0f / _t0;
        float _buf0 = 1.0f * _t0_inv;
        dd[1] = 0.0f;
        dd[2] = -(Math.fma(otherData[2], sd[0], sd[2]) * _t0_inv);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_affine_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = 0.0f;
        dd[2] = -(sd[2] * _rcp0);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_affine_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        float _buf0 = 1.0f * _rcp0;
        dd[1] = 0.0f;
        dd[2] = -(Math.fma(otherData[2], sd[0], sd[2]) * _rcp0);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_general_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = sd[3] * _t2_inv;
        dd[1] = -(sd[1] * _t2_inv);
        dd[2] = -(sd[2] * _t2_inv);
        dd[3] = sd[0] * _t2_inv;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_general_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = Math.fma(otherData[2], sd[1], sd[3]);
        float _t1 = Math.fma(otherData[2], sd[0], sd[2]);
        float _t4 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        float _t4_inv = 1.0f / _t4;
        float _buf0 = _t0 * _t4_inv;
        dd[1] = -(sd[1] * _t4_inv);
        dd[2] = -(_t1 * _t4_inv);
        dd[3] = sd[0] * _t4_inv;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float2x2 invertProduct_general_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = otherData[0] * sd[0];
        float _t1 = otherData[0] * sd[1];
        float _t2 = Math.fma(otherData[2], sd[1], sd[3]);
        float _t3 = Math.fma(otherData[2], sd[0], sd[2]);
        float _t6 = Math.fma(_t2, _t0, -(_t3 * _t1));
        float _t6_inv = 1.0f / _t6;
        dd[0] = _t2 * _t6_inv;
        dd[1] = -(_t1 * _t6_inv);
        dd[2] = -(_t3 * _t6_inv);
        dd[3] = _t0 * _t6_inv;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 invertProduct(Float2x2R other, @Mutated Float2x2 dest) {
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, dest);
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
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Float2x2 invertProduct(Float2x2R other) {
        if (Joml.RETURN_NEW) return invertProduct(other, Joml.float2x2());
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, this);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 invertProduct(Float2x2R other, @Mutated Double2x2 dest) {
        return invertProduct(other.m00(), other.m01(), other.m10(), other.m11(), dest);
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}) and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 invertProduct(float m00, float m01, float m10, float m11, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t4 = Math.fma(m01, sd[1], m11 * sd[3]);
        float _t5 = Math.fma(m00, sd[0], m10 * sd[2]);
        float _t6 = Math.fma(m00, sd[1], m10 * sd[3]);
        float _t7 = Math.fma(m01, sd[0], m11 * sd[2]);
        float _t10 = Math.fma(_t5, _t4, -(_t6 * _t7));
        float _t10_inv = 1.0f / _t10;
        dd[0] = _t4 * _t10_inv;
        dd[1] = -(_t6 * _t10_inv);
        dd[2] = -(_t7 * _t10_inv);
        dd[3] = _t5 * _t10_inv;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 invertProduct(float m00, float m01, float m10, float m11, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _t4 = Math.fma(m01, sd[1], m11 * sd[3]);
        float _t5 = Math.fma(m00, sd[0], m10 * sd[2]);
        float _t6 = Math.fma(m00, sd[1], m10 * sd[3]);
        float _t7 = Math.fma(m01, sd[0], m11 * sd[2]);
        float _t10 = Math.fma(_t5, _t4, -(_t6 * _t7));
        float _t10_inv = 1.0f / _t10;
        dd[0] = _t4 * _t10_inv;
        dd[1] = -(_t6 * _t10_inv);
        dd[2] = -(_t7 * _t10_inv);
        dd[3] = _t5 * _t10_inv;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_identity(@Mutated Float2x2 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_identity_self(@Mutated Float2x2 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_translation(@Mutated Float2x2 dest) {
        return cofactor_translation(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_translation_self(@Mutated Float2x2 dest) {
        return cofactor_translation_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_affine(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = -(sd[2] * _rcp0);
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_affine_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _rcp0 = 1.0f / sd[0];
        dd[0] = 1.0f * _rcp0;
        dd[1] = -(sd[2] * _rcp0);
        dd[2] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float2x2 normal_general(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = sd[3] * _t2_inv;
        float _buf1 = -(sd[2] * _t2_inv);
        dd[2] = -(sd[1] * _t2_inv);
        dd[3] = sd[0] * _t2_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 normal(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine(dest);
        return normal_general(dest);
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse.
     *
     * @return this
     */
    @Mutated public Float2x2 normal() {
        if (Joml.RETURN_NEW) return normal(Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_translation_self(this);
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
    public Double2x2 normal(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _t2 = Math.fma(sd[0], sd[3], -(sd[2] * sd[1]));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = sd[3] * _t2_inv;
        float _buf1 = -(sd[2] * _t2_inv);
        dd[2] = -(sd[1] * _t2_inv);
        dd[3] = sd[0] * _t2_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the trace of this matrix.
     *
     * @return the trace of this matrix
     */
    public float trace() {
        float[] sd = this.data;
        return sd[0] + sd[3];
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_identity(@Mutated Float2x2 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_identity_self(@Mutated Float2x2 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_translation(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = sd[2];
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_translation_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[1] = sd[2];
        dd[2] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_affine(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[2];
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_affine_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[2];
        dd[2] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float2x2 transpose_general(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[2];
        dd[2] = sd[1];
        dd[3] = sd[3];
        dd[1] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 transpose(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return transpose_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_affine(dest);
        return transpose_general(dest);
    }


    /**
     * Transpose this matrix.
     *
     * @return this
     */
    @Mutated public Float2x2 transpose() {
        if (Joml.RETURN_NEW) return transpose(Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return transpose_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_affine_self(this);
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
    public Double2x2 transpose(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[2];
        dd[2] = sd[1];
        dd[3] = sd[3];
        dd[1] = _buf0;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_general(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = otherData[1] + sd[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = otherData[3] + sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = 1.0f + otherData[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f + otherData[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f + otherData[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_identity_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 2.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_identity_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 2.0f;
        dd[1] = 0.0f;
        dd[2] = otherData[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_identity_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + otherData[0];
        dd[1] = 0.0f;
        dd[2] = otherData[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_translation_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 2.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_translation_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 2.0f;
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_translation_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + otherData[0];
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_affine_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + sd[0];
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_affine_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + sd[0];
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_affine_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 2.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_general_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0f + sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_general_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f + sd[0];
        dd[1] = sd[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f + sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float2x2 add_general_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = sd[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f + sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 add(Float2x2R other, @Mutated Float2x2 dest) {
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, dest);
            return add_translation(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_affine_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_affine_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_affine_affine(other, dest);
            return add_affine(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_general_affine(other, dest);
        return add_general(other, dest);
    }


    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Float2x2 add(Float2x2R other) {
        if (Joml.RETURN_NEW) return add(other, Joml.float2x2());
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, this);
            return add_translation(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_affine_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_affine_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_affine_affine(other, this);
            return add_affine(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_general_affine(other, this);
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
    public Double2x2 add(Float2x2R other, @Mutated Double2x2 dest) {
        return add(other.m00(), other.m01(), other.m10(), other.m11(), dest);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m10}, {@code m11}) to this matrix and store the result
     * in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 add(float m00, float m01, float m10, float m11, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = m00 + sd[0];
        dd[1] = m10 + sd[1];
        dd[2] = m01 + sd[2];
        dd[3] = m11 + sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m10}, {@code m11}) to this matrix and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 add(float m00, float m01, float m10, float m11, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = m00 + sd[0];
        dd[1] = m10 + sd[1];
        dd[2] = m01 + sd[2];
        dd[3] = m11 + sd[3];
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_identity(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_identity_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -1.0f;
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_translation(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -1.0f;
        dd[1] = 0.0f;
        dd[2] = -sd[2];
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_translation_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -1.0f;
        dd[2] = -sd[2];
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_affine(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = 0.0f;
        dd[2] = -sd[2];
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_affine_self(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -sd[0];
        dd[2] = -sd[2];
        dd[3] = -1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float2x2 negate_general(@Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 negate(@Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine(dest);
        return negate_general(dest);
    }


    /**
     * Negate this matrix.
     *
     * @return this
     */
    @Mutated public Float2x2 negate() {
        if (Joml.RETURN_NEW) return negate(Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_translation_self(this);
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
    public Double2x2 negate(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_general(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = sd[1] - otherData[1];
        dd[2] = sd[2] - otherData[2];
        dd[3] = sd[3] - otherData[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f - otherData[0];
        dd[1] = -otherData[1];
        dd[2] = -otherData[2];
        dd[3] = 1.0f - otherData[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_identity_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_identity_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = -otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_identity_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f - otherData[0];
        dd[1] = 0.0f;
        dd[2] = -otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_translation_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_translation_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2] - otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_translation_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f - otherData[0];
        dd[1] = 0.0f;
        dd[2] = sd[2] - otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_affine_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - 1.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_affine_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - 1.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2] - otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_affine_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = 0.0f;
        dd[2] = sd[2] - otherData[2];
        dd[3] = 0.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_general_identity(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - 1.0f;
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3] - 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_general_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - 1.0f;
        dd[1] = sd[1];
        dd[2] = sd[2] - otherData[2];
        dd[3] = sd[3] - 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float2x2 sub_general_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = sd[1];
        dd[2] = sd[2] - otherData[2];
        dd[3] = sd[3] - 1.0f;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 sub(Float2x2R other, @Mutated Float2x2 dest) {
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_affine_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_affine_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_affine_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_general_affine(other, dest);
        return sub_general(other, dest);
    }


    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Float2x2 sub(Float2x2R other) {
        if (Joml.RETURN_NEW) return sub(other, Joml.float2x2());
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_affine_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_affine_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_affine_affine(other, this);
            return sub_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_general_affine(other, this);
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
    public Double2x2 sub(Float2x2R other, @Mutated Double2x2 dest) {
        return sub(other.m00(), other.m01(), other.m10(), other.m11(), dest);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m10}, {@code m11}) from this matrix and store the
     * result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 sub(float m00, float m01, float m10, float m11, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] - m00;
        dd[1] = sd[1] - m10;
        dd[2] = sd[2] - m01;
        dd[3] = sd[3] - m11;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m10}, {@code m11}) from this matrix and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 sub(float m00, float m01, float m10, float m11, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0] - m00;
        dd[1] = sd[1] - m10;
        dd[2] = sd[2] - m01;
        dd[3] = sd[3] - m11;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Float2x2 set(Float2x2R v) {
        float[] dd = this.data;
        float[] vData = ((Float2x2Impl) v).data;
        dd[0] = vData[0];
        dd[1] = vData[1];
        dd[2] = vData[2];
        dd[3] = vData[3];
        ((Float2x2Impl) this).properties = ((Float2x2Impl) v).properties;
        return this;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @return this
     */
    @Mutated public Float2x2 set(float m00, float m01, float m10, float m11) {
        float[] dd = this.data;
        dd[0] = m00;
        dd[1] = m10;
        dd[2] = m01;
        dd[3] = m11;
        ((Float2x2Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x3 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float2x2 set(Float2x3R m) {
        float[] dd = this.data;
        float[] mData = ((Float2x3Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = mData[2];
        dd[3] = mData[3];
        ((Float2x2Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 3x3 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Float2x2 set(Float3x3R m) {
        float[] dd = this.data;
        float[] mData = ((Float3x3Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = mData[3];
        dd[3] = mData[4];
        ((Float2x2Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Convert this matrix to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 toDouble(@Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_identity(@Mutated Float2x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x3Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        ((Float2x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_translation(@Mutated Float2x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x3Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        ((Float2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_affine(@Mutated Float2x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = 0.0f;
        dd[2] = sd[2];
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        ((Float2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_general(@Mutated Float2x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x3Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[1] = _buf0;
        ((Float2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Extend this matrix to a 2x3 matrix with a zero translation column and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x3 to2x3(@Mutated Float2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to2x3_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return to2x3_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to2x3_affine(dest);
        return to2x3_general(dest);
    }


    /**
     * Extend this matrix to a 2x3 matrix with a zero translation column and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 to2x3(@Mutated Double2x3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[1] = _buf0;
        ((Double2x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_identity(@Mutated Float3x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 0.0f;
        dd[4] = 1.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        dd[8] = 1.0f;
        ((Float3x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_translation(@Mutated Float3x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = sd[2];
        dd[4] = 1.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        dd[8] = 1.0f;
        ((Float3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_affine(@Mutated Float3x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = sd[2];
        dd[4] = 1.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        dd[8] = 1.0f;
        ((Float3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_general(@Mutated Float3x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[1];
        dd[2] = 0.0f;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        dd[8] = 1.0f;
        dd[1] = _buf0;
        ((Float3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Extend this matrix to a 3x3 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 to3x3(@Mutated Float3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to3x3_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return to3x3_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to3x3_affine(dest);
        return to3x3_general(dest);
    }


    /**
     * Extend this matrix to a 3x3 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 to3x3(@Mutated Double3x3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        float _buf0 = sd[1];
        dd[2] = 0.0f;
        dd[3] = sd[2];
        dd[4] = sd[3];
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        dd[8] = 1.0f;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Float2x2 makeIdentity() {
        float[] dd = this.data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) this).properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_general(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherData[1] - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherData[3] - sd[3], sd[3]);
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_identity(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0f, 1.0f);
        dd[1] = t * otherData[1];
        dd[2] = t * otherData[2];
        dd[3] = Math.fma(t, otherData[3] - 1.0f, 1.0f);
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_translation(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0f, 1.0f);
        dd[1] = t * otherData[1];
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherData[3] - 1.0f, 1.0f);
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_orthogonal(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = 1.0f - t;
        dd[0] = Math.fma(t, otherData[0], _t0);
        dd[1] = t * otherData[1];
        dd[2] = Math.fma(t, otherData[2], Math.fma(-t, sd[2], sd[2]));
        dd[3] = Math.fma(t, otherData[3], _t0);
        ((Float2x2Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_affine(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = t * otherData[1];
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherData[3] - 1.0f, 1.0f);
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_identity_identity(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_identity_translation(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = t * otherData[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_identity_affine(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0f, 1.0f);
        dd[1] = 0.0f;
        dd[2] = t * otherData[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_translation_identity(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = Math.fma(-t, sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_translation_translation(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_translation_affine(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0f, 1.0f);
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_orthogonal_translation(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2], Math.fma(-t, sd[2], sd[2]));
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_orthogonal_affine(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0], 1.0f - t);
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2], Math.fma(-t, sd[2], sd[2]));
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_affine_identity(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, 1.0f - sd[0], sd[0]);
        dd[1] = 0.0f;
        dd[2] = Math.fma(-t, sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_affine_translation(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, 1.0f - sd[0], sd[0]);
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float2x2 lerp_affine_affine(Float2x2R other, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = 0.0f;
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
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
    public Float2x2 lerp(Float2x2R other, float t, @Mutated Float2x2 dest) {
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, dest);
            return lerp_orthogonal(other, t, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_affine_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_affine_affine(other, t, dest);
            return lerp_affine(other, t, dest);
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
    @Mutated public Float2x2 lerp(Float2x2R other, float t) {
        if (Joml.RETURN_NEW) return lerp(other, t, Joml.float2x2());
        int p = this.properties;
        int q = ((Float2x2Impl) other).properties;
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
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, this);
            return lerp_orthogonal(other, t, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_affine_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_affine_affine(other, t, this);
            return lerp_affine(other, t, this);
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
    public Double2x2 lerp(Float2x2R other, float t, @Mutated Double2x2 dest) {
        return lerp(other.m00(), other.m01(), other.m10(), other.m11(), t, dest);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}) using the interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 lerp(float m00, float m01, float m10, float m11, float t, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(t, m00 - sd[0], sd[0]);
        dd[1] = Math.fma(t, m10 - sd[1], sd[1]);
        dd[2] = Math.fma(t, m01 - sd[2], sd[2]);
        dd[3] = Math.fma(t, m11 - sd[3], sd[3]);
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}) using the interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 lerp(float m00, float m01, float m10, float m11, float t, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = Math.fma(t, m00 - sd[0], sd[0]);
        dd[1] = Math.fma(t, m10 - sd[1], sd[1]);
        dd[2] = Math.fma(t, m01 - sd[2], sd[2]);
        dd[3] = Math.fma(t, m11 - sd[3], sd[3]);
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_general(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[2]);
        float _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[3]);
        float _buf2 = Math.fma(rightData[2], sd[0], rightData[3] * sd[2]);
        dd[3] = Math.fma(rightData[2], sd[1], rightData[3] * sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_translation(Float2x2R right, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(rightData[1], sd[2], rightData[0]);
        dd[1] = rightData[1];
        dd[2] = Math.fma(rightData[3], sd[2], rightData[2]);
        dd[3] = rightData[3];
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_affine(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[2]);
        dd[1] = rightData[1];
        dd[2] = Math.fma(rightData[2], sd[0], rightData[3] * sd[2]);
        dd[3] = rightData[3];
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_translation_translation(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = rightData[2] + sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_translation_affine(Float2x2R right, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = 0.0f;
        dd[2] = rightData[2] + sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_affine_translation(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = sd[0];
        dd[1] = 0.0f;
        dd[2] = Math.fma(rightData[2], sd[0], sd[2]);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_affine_affine(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = rightData[0] * sd[0];
        dd[1] = 0.0f;
        dd[2] = Math.fma(rightData[2], sd[0], sd[2]);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_general_translation(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = sd[0];
        float _buf1 = sd[1];
        float _buf2 = Math.fma(rightData[2], sd[0], sd[2]);
        dd[3] = Math.fma(rightData[2], sd[1], sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2x2 mul_general_affine(Float2x2R right, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] rightData = ((Float2x2Impl) right).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = rightData[0] * sd[0];
        float _buf1 = rightData[0] * sd[1];
        float _buf2 = Math.fma(rightData[2], sd[0], sd[2]);
        dd[3] = Math.fma(rightData[2], sd[1], sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
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
    public Float2x2 mul(Float2x2R right, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Float2x2Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, dest, Joml.BIT_TRANSLATION & q);
            return mul_translation(right, dest, Joml.BIT_TRANSLATION & q);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_affine_translation(right, dest);
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
     * @return this
     */
    @Mutated public Float2x2 mul(Float2x2R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(right);
        int q = ((Float2x2Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, this, Joml.BIT_TRANSLATION & q);
            return mul_translation(right, this, Joml.BIT_TRANSLATION & q);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, this, Joml.BIT_ORTHOGONAL & q);
            return mul_translation(right, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_affine_translation(right, this);
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
    public Double2x2 mul(Float2x2R right, @Mutated Double2x2 dest) {
        return mul(right.m00(), right.m01(), right.m10(), right.m11(), dest);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m10}, {@code m11}) and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 mul(float m00, float m01, float m10, float m11, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(m00, sd[0], m10 * sd[2]);
        float _buf1 = Math.fma(m00, sd[1], m10 * sd[3]);
        dd[2] = Math.fma(m01, sd[0], m11 * sd[2]);
        dd[3] = Math.fma(m01, sd[1], m11 * sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m10}, {@code m11}) and store the
     * result in {@code dest}.
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
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 mul(float m00, float m01, float m10, float m11, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _buf0 = Math.fma(m00, sd[0], m10 * sd[2]);
        float _buf1 = Math.fma(m00, sd[1], m10 * sd[3]);
        dd[2] = Math.fma(m01, sd[0], m11 * sd[2]);
        dd[3] = Math.fma(m01, sd[1], m11 * sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_general(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        float _buf1 = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        float _buf2 = Math.fma(otherData[0], sd[2], otherData[2] * sd[3]);
        dd[3] = Math.fma(otherData[1], sd[2], otherData[3] * sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_translation(Float2x2R other, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = otherData[0];
        float _buf1 = otherData[1];
        float _buf2 = Math.fma(otherData[0], sd[2], otherData[2]);
        dd[3] = Math.fma(otherData[1], sd[2], otherData[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = otherData[0] * sd[0];
        float _buf1 = otherData[1] * sd[0];
        float _buf2 = Math.fma(otherData[0], sd[2], otherData[2]);
        dd[3] = Math.fma(otherData[1], sd[2], otherData[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_translation_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = 1.0f;
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_TRANSLATION & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_translation_affine(Float2x2R other, @Mutated Float2x2 dest, int _props) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = otherData[0];
        dd[1] = 0.0f;
        dd[2] = Math.fma(otherData[0], sd[2], otherData[2]);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_affine_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = 0.0f;
        dd[2] = otherData[2] + sd[2];
        dd[3] = 1.0f;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_affine_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = otherData[0] * sd[0];
        dd[1] = 0.0f;
        dd[2] = Math.fma(otherData[0], sd[2], otherData[2]);
        dd[3] = 1.0f;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = Joml.BIT_AFFINE & ((Float2x2Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_general_translation(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = Math.fma(otherData[2], sd[1], sd[0]);
        dd[1] = sd[1];
        dd[2] = Math.fma(otherData[2], sd[3], sd[2]);
        dd[3] = sd[3];
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float2x2 preMul_general_affine(Float2x2R other, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] otherData = ((Float2x2Impl) other).data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = sd[1];
        dd[2] = Math.fma(otherData[0], sd[2], otherData[2] * sd[3]);
        dd[3] = sd[3];
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 preMul(Float2x2R other, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Float2x2Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, dest, Joml.BIT_TRANSLATION & q);
            return preMul_translation(other, dest, Joml.BIT_TRANSLATION & q);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_affine_translation(other, dest);
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
     * @return this
     */
    @Mutated public Float2x2 preMul(Float2x2R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(other);
        int q = ((Float2x2Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, this, Joml.BIT_TRANSLATION & q);
            return preMul_translation(other, this, Joml.BIT_TRANSLATION & q);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, this, Joml.BIT_ORTHOGONAL & q);
            return preMul_translation(other, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_affine_translation(other, this);
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
    public Double2x2 preMul(Float2x2R other, @Mutated Double2x2 dest) {
        return preMul(other.m00(), other.m01(), other.m10(), other.m11(), dest);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m10}, {@code m11}) onto
     * this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float2x2 preMul(float m00, float m01, float m10, float m11, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _buf0 = Math.fma(m00, sd[0], m01 * sd[1]);
        dd[1] = Math.fma(m10, sd[0], m11 * sd[1]);
        float _buf1 = Math.fma(m00, sd[2], m01 * sd[3]);
        dd[3] = Math.fma(m10, sd[2], m11 * sd[3]);
        dd[0] = _buf0;
        dd[2] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m10}, {@code m11}) onto
     * this matrix and store the result in {@code dest}.
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
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 preMul(float m00, float m01, float m10, float m11, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _buf0 = Math.fma(m00, sd[0], m01 * sd[1]);
        dd[1] = Math.fma(m10, sd[0], m11 * sd[1]);
        float _buf1 = Math.fma(m00, sd[2], m01 * sd[3]);
        dd[3] = Math.fma(m10, sd[2], m11 * sd[3]);
        dd[0] = _buf0;
        dd[2] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set this matrix to the outer product of {@code col} and {@code row}.
     *
     * @param col the column vector (left operand)
     * @param row the row vector (right operand)
     * @return this
     */
    public @Mutated Float2x2 makeOuterProduct(Float2R col, Float2R row) {
        return makeOuterProduct(col.x(), col.y(), row.x(), row.y());
    }


    /**
     * Set this matrix to the outer product of ({@code colX}, {@code colY}) and ({@code rowX},
     * {@code rowY}).
     *
     * @param colX the {@code x} component of the vector {@code (colX, colY)}
     * @param colY the {@code y} component of the vector {@code (colX, colY)}
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY)}
     * @return this
     */
    @Mutated public Float2x2 makeOuterProduct(float colX, float colY, float rowX, float rowY) {
        float[] dd = this.data;
        dd[0] = colX * rowX;
        dd[1] = colY * rowX;
        dd[2] = colX * rowY;
        dd[3] = colY * rowY;
        ((Float2x2Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Float2x2 makeRotation(float angle) {
        float[] dd = this.data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        ((Float2x2Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Float2x2 makeScaling(Float2R v) {
        return makeScaling(v.x(), v.y());
    }


    /**
     * Set this matrix to a scaling transformation that scales by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Float2x2 makeScaling(float vX, float vY) {
        float[] dd = this.data;
        dd[0] = vX;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = vY;
        ((Float2x2Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Float2x2 makeScaling(float s) {
        float[] dd = this.data;
        dd[0] = s;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = s;
        ((Float2x2Impl) this).properties = 0;
        return this;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float2x2 preRotate_identity(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = -_t1;
        dd[3] = _t0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float2x2 preRotate_translation(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        float _buf0 = Math.fma(sd[2], _t0, -_t1);
        dd[3] = Math.fma(sd[2], _t1, _t0);
        dd[2] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float2x2 preRotate_affine(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = sd[0] * _t0;
        dd[1] = sd[0] * _t1;
        float _buf1 = Math.fma(sd[2], _t0, -_t1);
        dd[3] = Math.fma(sd[2], _t1, _t0);
        dd[0] = _buf0;
        dd[2] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float2x2 preRotate_general(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        float _buf1 = Math.fma(sd[2], _t0, -(sd[3] * _t1));
        dd[3] = Math.fma(sd[2], _t1, sd[3] * _t0);
        dd[0] = _buf0;
        dd[2] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 preRotate(float angle, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_affine(angle, dest);
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
     * @return this
     */
    @Mutated public Float2x2 preRotate(float angle) {
        if (Joml.RETURN_NEW) return preRotate(angle, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotate_translation(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_affine(angle, this);
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
    public Double2x2 preRotate(float angle, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        float _buf1 = Math.fma(sd[2], _t0, -(sd[3] * _t1));
        dd[3] = Math.fma(sd[2], _t1, sd[3] * _t0);
        dd[0] = _buf0;
        dd[2] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
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
    public Float2x2 preScale(Float2R v, @Mutated Float2x2 dest) {
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
    public Double2x2 preScale(Float2R v, @Mutated Double2x2 dest) {
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
     * @return this
     */
    public @Mutated Float2x2 preScale(Float2R v) {
        return preScale(v.x(), v.y());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_identity(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_identity_self(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_translation(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0f;
        dd[2] = sd[2] * vX;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_translation_self(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[2] = sd[2] * vX;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_affine(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = 0.0f;
        dd[2] = sd[2] * vX;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_affine_self(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[2] = sd[2] * vX;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_general(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[2] = sd[2] * vX;
        dd[3] = sd[3] * vY;
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 preScale(float vX, float vY, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preScale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_affine(vX, vY, dest);
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
     * @return this
     */
    @Mutated public Float2x2 preScale(float vX, float vY) {
        if (Joml.RETURN_NEW) return preScale(vX, vY, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preScale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_affine_self(vX, vY, this);
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
    public Double2x2 preScale(float vX, float vY, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[2] = sd[2] * vX;
        dd[3] = sd[3] * vY;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_identity(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_identity_self(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s;
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_translation(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0f;
        dd[2] = s * sd[2];
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_translation_self(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s;
        dd[2] = s * sd[2];
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_affine(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = 0.0f;
        dd[2] = s * sd[2];
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_affine_self(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s * sd[0];
        dd[2] = s * sd[2];
        dd[3] = s;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float2x2 preScale_general(float s, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 preScale(float s, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preScale_translation(s, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_affine(s, dest);
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
    @Mutated public Float2x2 preScale(float s) {
        if (Joml.RETURN_NEW) return preScale(s, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(s, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preScale_translation_self(s, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_affine_self(s, this);
        return preScale_general(s, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix and store the result in {@code dest}.
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
    public Double2x2 preScale(float s, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float2x2 rotate_identity(float angle, @Mutated Float2x2 dest) {
        return preRotate_identity(angle, dest);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float2x2 rotate_translation(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        dd[0] = Math.fma(sd[2], _t0, _t1);
        dd[1] = _t0;
        dd[2] = Math.fma(sd[2], _t1, -_t0);
        dd[3] = _t1;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float2x2 rotate_affine(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        dd[1] = _t1;
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[3] = _t0;
        dd[0] = _buf0;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float2x2 rotate_general(float angle, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        float _buf1 = Math.fma(sd[1], _t0, sd[3] * _t1);
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[3] = Math.fma(sd[3], _t0, -(sd[1] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 rotate(float angle, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_affine(angle, dest);
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
     * @return this
     */
    @Mutated public Float2x2 rotate(float angle) {
        if (Joml.RETURN_NEW) return rotate(angle, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotate_translation(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_affine(angle, this);
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
    public Double2x2 rotate(float angle, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        float _buf1 = Math.fma(sd[1], _t0, sd[3] * _t1);
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[3] = Math.fma(sd[3], _t0, -(sd[1] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double2x2Impl) dest).properties = 0;
        return dest;
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
    public Float2x2 scale(Float2R v, @Mutated Float2x2 dest) {
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
    public Double2x2 scale(Float2R v, @Mutated Double2x2 dest) {
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
     * @return this
     */
    public @Mutated Float2x2 scale(Float2R v) {
        return scale(v.x(), v.y());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float2x2 scale_identity(float vX, float vY, @Mutated Float2x2 dest) {
        return preScale_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float2x2 scale_identity_self(float vX, float vY, @Mutated Float2x2 dest) {
        return preScale_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float2x2 scale_translation(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0f;
        dd[2] = sd[2] * vY;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float2x2 scale_translation_self(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = vX;
        dd[2] = sd[2] * vY;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float2x2 scale_affine(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = 0.0f;
        dd[2] = sd[2] * vY;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Float2x2 scale_affine_self(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[2] = sd[2] * vY;
        dd[3] = vY;
        ((Float2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float2x2 scale_general(float vX, float vY, @Mutated Float2x2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[2] = sd[2] * vY;
        dd[3] = sd[3] * vY;
        ((Float2x2Impl) dest).properties = 0;
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
    public Float2x2 scale(float vX, float vY, @Mutated Float2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_affine(vX, vY, dest);
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
     * @return this
     */
    @Mutated public Float2x2 scale(float vX, float vY) {
        if (Joml.RETURN_NEW) return scale(vX, vY, Joml.float2x2());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_affine_self(vX, vY, this);
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
    public Double2x2 scale(float vX, float vY, @Mutated Double2x2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[2] = sd[2] * vY;
        dd[3] = sd[3] * vY;
        ((Double2x2Impl) dest).properties = 0;
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
    public Float2x2 scale(float s, @Mutated Float2x2 dest) {
        return preScale(s, dest);
    }


    /**
     * Apply a scaling by {@code s} to this matrix and store the result in {@code dest}.
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
    public Double2x2 scale(float s, @Mutated Double2x2 dest) {
        return preScale(s, dest);
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
    @Mutated public Float2x2 scale(float s) {
        return preScale(s);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float2 mul(Float2R v, @Mutated Float2 dest) {
        return mul(v.x(), v.y(), dest);
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
    public Double2 mul(Float2R v, @Mutated Double2 dest) {
        return mul(v.x(), v.y(), dest);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2 mul_identity(float vX, float vY, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        dd[0] = vX;
        dd[1] = vY;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2 mul_translation(float vX, float vY, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        dd[0] = Math.fma(sd[2], vY, vX);
        dd[1] = vY;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2 mul_affine(float vX, float vY, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        dd[0] = Math.fma(sd[0], vX, sd[2] * vY);
        dd[1] = vY;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float2 mul_general(float vX, float vY, @Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        dd[0] = Math.fma(sd[0], vX, sd[2] * vY);
        dd[1] = Math.fma(sd[1], vX, sd[3] * vY);
        return dest;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float2 mul(float vX, float vY, @Mutated Float2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine(vX, vY, dest);
        return mul_general(vX, vY, dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 mul(float vX, float vY, @Mutated Double2 dest) {
        float[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.fma(sd[0], vX, sd[2] * vY);
        dd[1] = Math.fma(sd[1], vX, sd[3] * vY);
        return dest;
    }

    public float m00() { return data[0]; }
    public float m01() { return data[2]; }
    public float m10() { return data[1]; }
    public float m11() { return data[3]; }

    @Override public String toString() {
        return "Float2x2(\n    " + m00() + ", " + m01() + "\n    " + m10() + ", " + m11() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float2x2Impl)) return false;
        Float2x2Impl o = (Float2x2Impl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2])
            && Float.isFinite(data[3]);
    }

    @Override public boolean equalsEpsilon(Float2x2R other, float epsilon) {
        return Math.abs(data[0] - other.m00()) <= epsilon
            && Math.abs(data[2] - other.m01()) <= epsilon
            && Math.abs(data[1] - other.m10()) <= epsilon
            && Math.abs(data[3] - other.m11()) <= epsilon;
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadCM(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float2x2 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Float2x2 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Float2x2 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Float2x2 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM(this, offset, dest);
    }
    public Float2x2 loadCM(long offset, MemorySegment src) {
        return SEG_OPS.loadCM(this, offset, src);
    }

    public double[] storeCM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadCM(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float2x2 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf);
    }
    public Float2x2 loadCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf);
    }
    public Float2x2 storeCMDoubleUnsafe(long address) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address);
    }
    @Mutated public Float2x2 loadCMDoubleUnsafe(long address) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address);
    }
    public MemorySegment storeCMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeCMDouble(this, offset, dest);
    }
    public Float2x2 loadCMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadCMDouble(this, offset, src);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        if (dest == this.data) return storeRM_aliased(dest, offset);
        return storeRM_distinct(dest, offset);
    }
    private float[] storeRM_distinct(float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = this.data[1];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    private float[] storeRM_aliased(float[] dest, int offset) {
        float[] d = this.data;
        float t0 = d[0];
        float t1 = d[1];
        float t2 = d[2];
        float t3 = d[3];
        dest[offset + 0] = t0;
        dest[offset + 1] = t2;
        dest[offset + 2] = t1;
        dest[offset + 3] = t3;
        return dest;
    }
    @Mutated public Float2x2 loadRM(float[] src, int offset) {
        if (src == this.data) return loadRM_aliased(src, offset);
        return loadRM_distinct(src, offset);
    }
    private Float2x2 loadRM_distinct(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[2] = src[offset + 1];
        this.data[1] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.properties = determineProperties();
        return this;
    }
    private Float2x2 loadRM_aliased(float[] src, int offset) {
        float t0 = src[offset + 0];
        float t1 = src[offset + 1];
        float t2 = src[offset + 2];
        float t3 = src[offset + 3];
        float[] d = this.data;
        d[0] = t0;
        d[2] = t1;
        d[1] = t2;
        d[3] = t3;
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float2x2 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Float2x2 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Float2x2 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Float2x2 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM(this, offset, dest);
    }
    public Float2x2 loadRM(long offset, MemorySegment src) {
        return SEG_OPS.loadRM(this, offset, src);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = this.data[1];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadRM(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[2] = (float) src[offset + 1];
        this.data[1] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float2x2 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf);
    }
    public Float2x2 loadRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf);
    }
    public Float2x2 storeRMDoubleUnsafe(long address) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address);
    }
    @Mutated public Float2x2 loadRMDoubleUnsafe(long address) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address);
    }
    public MemorySegment storeRMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeRMDouble(this, offset, dest);
    }
    public Float2x2 loadRMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadRMDouble(this, offset, src);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[_p1] = this.data[2];
        dest[_p1 + 1] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = src[offset];
        this.data[1] = src[offset + 1];
        this.data[2] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float2x2 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Float2x2 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Float2x2 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Float2x2 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCM(this, offset, dest, stride);
    }
    public Float2x2 loadCM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCM(this, offset, src, stride);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[_p1] = this.data[2];
        dest[_p1 + 1] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = (float) src[offset];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[_p1];
        this.data[3] = (float) src[_p1 + 1];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float2x2 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float2x2 loadCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float2x2 storeCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float2x2 loadCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address, stride);
    }
    public MemorySegment storeCMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCMDouble(this, offset, dest, stride);
    }
    public Float2x2 loadCMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCMDouble(this, offset, src, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        if (dest == this.data) return storeRM_aliased(dest, offset, stride);
        return storeRM_distinct(dest, offset, stride);
    }
    private float[] storeRM_distinct(float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[_p1] = this.data[1];
        dest[_p1 + 1] = this.data[3];
        return dest;
    }
    private float[] storeRM_aliased(float[] dest, int offset, int stride) {
        float[] d = this.data;
        float t0 = d[0];
        float t1 = d[1];
        float t2 = d[2];
        float t3 = d[3];
        int _p1 = offset + stride;
        dest[offset] = t0;
        dest[offset + 1] = t2;
        dest[_p1] = t1;
        dest[_p1 + 1] = t3;
        return dest;
    }
    @Mutated public Float2x2 loadRM(float[] src, int offset, int stride) {
        if (src == this.data) return loadRM_aliased(src, offset, stride);
        return loadRM_distinct(src, offset, stride);
    }
    private Float2x2 loadRM_distinct(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = src[offset];
        this.data[2] = src[offset + 1];
        this.data[1] = src[_p1];
        this.data[3] = src[_p1 + 1];
        this.properties = determineProperties();
        return this;
    }
    private Float2x2 loadRM_aliased(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        float t0 = src[offset];
        float t1 = src[offset + 1];
        float t2 = src[_p1];
        float t3 = src[_p1 + 1];
        float[] d = this.data;
        d[0] = t0;
        d[2] = t1;
        d[1] = t2;
        d[3] = t3;
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float2x2 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Float2x2 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Float2x2 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Float2x2 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRM(this, offset, dest, stride);
    }
    public Float2x2 loadRM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRM(this, offset, src, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[_p1] = this.data[1];
        dest[_p1 + 1] = this.data[3];
        return dest;
    }
    public @Mutated Float2x2 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.data[0] = (float) src[offset];
        this.data[2] = (float) src[offset + 1];
        this.data[1] = (float) src[_p1];
        this.data[3] = (float) src[_p1 + 1];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float2x2 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float2x2 loadRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float2x2 storeRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float2x2 loadRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address, stride);
    }
    public MemorySegment storeRMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRMDouble(this, offset, dest, stride);
    }
    public Float2x2 loadRMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRMDouble(this, offset, src, stride);
    }

    public float[] storeCM3x3(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = this.data[2];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = 0.0f;
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 1.0f;
        return dest;
    }
    public FloatBuffer storeCM3x3Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeCM3x3Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public Float2x2 storeCM3x3Unsafe(long address) {
        return RAW_OPS.storeCM3x3Unsafe(this, address);
    }
    public MemorySegment storeCM3x3(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM3x3(this, offset, dest);
    }

    public double[] storeCM3x3(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = this.data[2];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = 0.0f;
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 1.0f;
        return dest;
    }
    public DoubleBuffer storeCM3x3Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeCM3x3DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM3x3DoubleAbsolute(this, index, buf);
    }
    public Float2x2 storeCM3x3DoubleUnsafe(long address) {
        return RAW_OPS.storeCM3x3DoubleUnsafe(this, address);
    }
    public MemorySegment storeCM3x3Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM3x3Double(this, offset, dest);
    }

    public float[] storeRM3x3(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = this.data[1];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = 0.0f;
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 1.0f;
        return dest;
    }
    public FloatBuffer storeRM3x3Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeRM3x3Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public Float2x2 storeRM3x3Unsafe(long address) {
        return RAW_OPS.storeRM3x3Unsafe(this, address);
    }
    public MemorySegment storeRM3x3(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM3x3(this, offset, dest);
    }

    public double[] storeRM3x3(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = this.data[1];
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = 0.0f;
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 1.0f;
        return dest;
    }
    public DoubleBuffer storeRM3x3Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRM3x3Absolute(this, index, buf);
    }
    public ByteBuffer storeRM3x3DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM3x3DoubleAbsolute(this, index, buf);
    }
    public Float2x2 storeRM3x3DoubleUnsafe(long address) {
        return RAW_OPS.storeRM3x3DoubleUnsafe(this, address);
    }
    public MemorySegment storeRM3x3Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM3x3Double(this, offset, dest);
    }

    public float[] storeCM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.data[2];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 0.0f;
        dest[offset + 9] = 0.0f;
        dest[offset + 10] = 1.0f;
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
    public Float2x2 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }
    public MemorySegment storeCM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4(this, offset, dest);
    }

    public double[] storeCM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.data[2];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 0.0f;
        dest[offset + 9] = 0.0f;
        dest[offset + 10] = 1.0f;
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
    public Float2x2 storeCM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeCM4x4DoubleUnsafe(this, address);
    }
    public MemorySegment storeCM4x4Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4Double(this, offset, dest);
    }

    public float[] storeRM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.data[1];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 0.0f;
        dest[offset + 9] = 0.0f;
        dest[offset + 10] = 1.0f;
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
    public Float2x2 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }
    public MemorySegment storeRM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4(this, offset, dest);
    }

    public double[] storeRM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[2];
        dest[offset + 2] = 0.0f;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.data[1];
        dest[offset + 5] = this.data[3];
        dest[offset + 6] = 0.0f;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = 0.0f;
        dest[offset + 9] = 0.0f;
        dest[offset + 10] = 1.0f;
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
    public Float2x2 storeRM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeRM4x4DoubleUnsafe(this, address);
    }
    public MemorySegment storeRM4x4Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4Double(this, offset, dest);
    }

}
